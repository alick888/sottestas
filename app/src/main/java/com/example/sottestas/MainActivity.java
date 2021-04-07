package com.example.sottestas;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;

import org.eclipse.paho.client.mqttv3.*;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
//import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert;

import java.math.BigInteger;
import java.util.concurrent.*;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.RequestQueue;

public class MainActivity extends AppCompatActivity {

    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    private String currentCity = "";

    public MapView mMapView = null;

    private Button mShowSnackbarButton;
    private CoordinatorLayout mCoordinatorLayout;
    private TextView mdisplayPayload;
    private Alicoin_ico alicoin_ico;
    String pk = "2b5bff1514cd738d3a772ec03f51f30d555e21f8bec9e2b0eb59649b21bcb78d";  //Ropsten
//    String pk = "84a32dbf34f589ce993508fc1e7edf0965489b80097bdbafbeeee3b6b5ef2916";  //Ganache
    String contractAddress = "0x061323998Ebcdd42cf1330f7409B62cF38cD733D";  //Ropsten
//    String contractAddress = "0x040E591BF036c08460C0a4d6b0d9dA50760a37df";  //Ganache

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mdisplayPayload = (TextView) findViewById(R.id.displayPayload);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //making web request
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://192.168.86.234:8000/alicoin/ipfs_test";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        runOnUiThread(new Runnable() {
                            public void run() {
                                System.out.println("Response from IPFS: " + response);
                                mdisplayPayload.setText(response);
                            }
                        });
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                runOnUiThread(new Runnable() {
                    public void run() {
                        mdisplayPayload.setText("That didn't work!" + error);
                        System.out.println("That didn't work!" + error);
                    }
                });
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);


        Credentials credentials = Credentials.create(pk);
        Toast.makeText(this, "Your address is " + credentials.getAddress(), Toast.LENGTH_LONG).show();

        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.map);
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，创建地图
        mMapView.onCreate(savedInstanceState);
        AMap aMap = mMapView.getMap();
        aMap.setMapLanguage(AMap.ENGLISH);  //AMap.CHINESE 表示中文
        aMap.setMyLocationEnabled(true);

        final String publish_topic        = "sotbc";
        String request_topic = "sot_request";
        String content      = "Message from MqttPublishSample";
        final int qos             = 2;
        String broker       = "tcp://postintl-sg-ees1rs82001.mqtt.aliyuncs.com:1883";
        String clientId     = "GID_sotbc@@@0001";
        final String username    = "Signature|LTAI4GBUCgFUHGnXwMAXos6v|postintl-sg-ees1rs82001";
        final String password    = "22k5QZGqxn8Tpo5CGD7zBXF32b0=";
//        MemoryPersistence persistence = new MemoryPersistence();
//初始化定位
        mLocationClient = new AMapLocationClient(getApplicationContext());
//异步获取定位结果
        AMapLocationListener mAMapLocationListener = new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation amapLocation) {
                if (amapLocation != null) {
                    if (amapLocation.getErrorCode() == 0) {
                        //解析定位结果
                        if(!currentCity.equals(amapLocation.getCity())) {
                            System.out.println("Location: " + amapLocation.getCity());
                            currentCity = amapLocation.getCity();
                            runOnUiThread(new Runnable() {
                                public void run() {
                                    mdisplayPayload.setText("Current City: "+ amapLocation.getCity());
                                }
                            });
                        }
                    }
                }
            }
        };
//设置定位回调监听
        mLocationClient.setLocationListener(mAMapLocationListener);
//启动定位
        mLocationClient.startLocation();
        AMapLocation aMapLocation = mLocationClient.getLastKnownLocation();
        if(aMapLocation != null) {
            currentCity = mLocationClient.getLastKnownLocation().getCity();
            System.out.println("Location: " + currentCity);
            mdisplayPayload.setText("Current City: " + currentCity);
            mLocationClient.getLastKnownLocation().getCity();
        }

        try {
//            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            final MqttClient sampleClient = new MqttClient(broker, clientId, null);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            connOpts.setUserName(username);
            connOpts.setPassword(password.toCharArray());
            System.out.println("Connecting to broker: "+broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            System.out.println("Publishing message: "+content);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            sampleClient.publish(publish_topic, message);
            System.out.println("Message published");
//            sampleClient.disconnect();
//            System.out.println("Disconnected");
//            System.exit(0);
//            sampleClient.publish(topic, message);
            sampleClient.subscribe(request_topic, new IMqttMessageListener() {
                public void messageArrived (final String topic, final MqttMessage message) throws Exception {
                    final String payload = new String(message.getPayload());

                    System.out.println("Received operation " + payload);
                    if (payload.startsWith("update")) {
                        runOnUiThread(new Runnable() {
                            public void run() {
                                mdisplayPayload.setText(payload);
                            }
                        });

                        // execute the operation in another thread to allow the MQTT client to
                        // finish processing this message and acknowledge receipt to the server
                        Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                            public void run() {
                                try {
                                    MqttMessage out_message = new MqttMessage("Simulating device restart...".getBytes());
                                    out_message.setQos(qos);
                                    System.out.println("Simulating device restart...");
                                    sampleClient.publish(publish_topic, out_message);
                                    System.out.println("...restarting...");
                                    Thread.sleep(TimeUnit.SECONDS.toMillis(5));
                                    out_message.setPayload("...restarting...".getBytes());
                                    sampleClient.publish(publish_topic, out_message);
                                    System.out.println("...done...");
                                } catch (MqttException e) {
                                    e.printStackTrace();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                }
            });
        }catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
        // FIXME: Add your own API key here
        Web3j web3 = Web3j.build(new HttpService("https://ropsten.infura.io/v3/0178c83df5254ba8a084515d97a7fc9e"));  //Ropsten
        try {
            Web3ClientVersion clientVersion = web3.web3ClientVersion().sendAsync().get();
            if(!clientVersion.hasError()){
                //Connected
                System.out.println("connected ");
                System.out.println("Account address: " + credentials.getAddress());
                EthGetBalance ethbalance = web3.ethGetBalance(credentials.getAddress(), DefaultBlockParameterName.LATEST).sendAsync().get();
                String user_balance = ethbalance.getBalance().toString();;
                System.out.println("Balance: " + Convert.fromWei(user_balance, Convert.Unit.ETHER));
                alicoin_ico = Alicoin_ico.load(contractAddress, web3, credentials, new DefaultGasProvider());
                System.out.println("Contract loaded");
            }
            else {
                //Show Error
                System.out.println("not connected ");
            }
        }
        catch (Exception e) {
            //Show Error
            System.out.println(e);
            e.printStackTrace();
        }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        mShowSnackbarButton = (Button) findViewById(R.id.showSnackbarButton);
        mShowSnackbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(mCoordinatorLayout,
                        "This is a simple Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("CLOSE", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // Custom action
                            }
                        }).show();
                // FIXME: Add your own API key here
                try {
                    Uint256 receipt = alicoin_ico.max_alicoins().sendAsync().get();
//                        TransactionReceipt receipt = alicoin_ico.buy_alicoins(credentials.getAddress(), BigInteger.valueOf(6)).sendAsync().get();
//                        String txHash = receipt.getTransactionHash();
                    System.out.println("Max Alicoin is: "+ receipt.getValue().toString());
                    runOnUiThread(new Runnable() {
                        public void run() {
                            mdisplayPayload.setText("Max Alicoin is: "+ receipt.getValue().toString());
                        }
                    });
                }
                catch (Exception e) {
                    //Show Error
                    System.out.println(e);
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //Gaode Map
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        mMapView.onDestroy();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mMapView.onPause();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mMapView.onSaveInstanceState(outState);
    }
}

