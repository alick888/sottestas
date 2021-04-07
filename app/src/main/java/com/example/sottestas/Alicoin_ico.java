package com.example.sottestas;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.1.1.
 */
public class Alicoin_ico extends Contract {
    private static final String BINARY = "{\r\n"
            + "\t\"linkReferences\": {},\r\n"
            + "\t\"object\": \"6080604052620f42406000556103e8600155600060025534801561002257600080fd5b50610503806100326000396000f3fe608060405234801561001057600080fd5b506004361061007d5760003560e01c80633a65dc511161005b5780633a65dc5114610146578063bea45a451461019e578063c9fc5990146101bc578063d1a99785146101da5761007d565b8063025a38811461008257806310c51c1b146100a057806331b349dd146100f8575b600080fd5b61008a610228565b6040518082815260200191505060405180910390f35b6100e2600480360360208110156100b657600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061022e565b6040518082815260200191505060405180910390f35b6101446004803603604081101561010e57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610277565b005b6101886004803603602081101561015c57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610389565b6040518082815260200191505060405180910390f35b6101a66103d2565b6040518082815260200191505060405180910390f35b6101c46103d8565b6040518082815260200191505060405180910390f35b610226600480360360408110156101f057600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291905050506103de565b005b60015481565b6000600460008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020549050919050565b80600054600254600154830201111561028f57600080fd5b60006001548302905080600360008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008282540192505081905550600154600360008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020548161032f57fe5b04600460008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055508060026000828254019250508190555050505050565b6000600360008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020549050919050565b60025481565b60005481565b80600360008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008282540392505081905550600154600360008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020548161047557fe5b04600460008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208190555080600260008282540392505081905550505056fea2646970667358221220be597c7e4d1b30b1060187581db11e1e228e8f904c8be8d78a7b423225a81baf64736f6c63430006060033\",\r\n"
            + "\t\"opcodes\": \"PUSH1 0x80 PUSH1 0x40 MSTORE PUSH3 0xF4240 PUSH1 0x0 SSTORE PUSH2 0x3E8 PUSH1 0x1 SSTORE PUSH1 0x0 PUSH1 0x2 SSTORE CALLVALUE DUP1 ISZERO PUSH2 0x22 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x503 DUP1 PUSH2 0x32 PUSH1 0x0 CODECOPY PUSH1 0x0 RETURN INVALID PUSH1 0x80 PUSH1 0x40 MSTORE CALLVALUE DUP1 ISZERO PUSH2 0x10 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH1 0x4 CALLDATASIZE LT PUSH2 0x7D JUMPI PUSH1 0x0 CALLDATALOAD PUSH1 0xE0 SHR DUP1 PUSH4 0x3A65DC51 GT PUSH2 0x5B JUMPI DUP1 PUSH4 0x3A65DC51 EQ PUSH2 0x146 JUMPI DUP1 PUSH4 0xBEA45A45 EQ PUSH2 0x19E JUMPI DUP1 PUSH4 0xC9FC5990 EQ PUSH2 0x1BC JUMPI DUP1 PUSH4 0xD1A99785 EQ PUSH2 0x1DA JUMPI PUSH2 0x7D JUMP JUMPDEST DUP1 PUSH4 0x25A3881 EQ PUSH2 0x82 JUMPI DUP1 PUSH4 0x10C51C1B EQ PUSH2 0xA0 JUMPI DUP1 PUSH4 0x31B349DD EQ PUSH2 0xF8 JUMPI JUMPDEST PUSH1 0x0 DUP1 REVERT JUMPDEST PUSH2 0x8A PUSH2 0x228 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 DUP3 DUP2 MSTORE PUSH1 0x20 ADD SWAP2 POP POP PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST PUSH2 0xE2 PUSH1 0x4 DUP1 CALLDATASIZE SUB PUSH1 0x20 DUP2 LT ISZERO PUSH2 0xB6 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST DUP2 ADD SWAP1 DUP1 DUP1 CALLDATALOAD PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND SWAP1 PUSH1 0x20 ADD SWAP1 SWAP3 SWAP2 SWAP1 POP POP POP PUSH2 0x22E JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 DUP3 DUP2 MSTORE PUSH1 0x20 ADD SWAP2 POP POP PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST PUSH2 0x144 PUSH1 0x4 DUP1 CALLDATASIZE SUB PUSH1 0x40 DUP2 LT ISZERO PUSH2 0x10E JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST DUP2 ADD SWAP1 DUP1 DUP1 CALLDATALOAD PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND SWAP1 PUSH1 0x20 ADD SWAP1 SWAP3 SWAP2 SWAP1 DUP1 CALLDATALOAD SWAP1 PUSH1 0x20 ADD SWAP1 SWAP3 SWAP2 SWAP1 POP POP POP PUSH2 0x277 JUMP JUMPDEST STOP JUMPDEST PUSH2 0x188 PUSH1 0x4 DUP1 CALLDATASIZE SUB PUSH1 0x20 DUP2 LT ISZERO PUSH2 0x15C JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST DUP2 ADD SWAP1 DUP1 DUP1 CALLDATALOAD PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND SWAP1 PUSH1 0x20 ADD SWAP1 SWAP3 SWAP2 SWAP1 POP POP POP PUSH2 0x389 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 DUP3 DUP2 MSTORE PUSH1 0x20 ADD SWAP2 POP POP PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST PUSH2 0x1A6 PUSH2 0x3D2 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 DUP3 DUP2 MSTORE PUSH1 0x20 ADD SWAP2 POP POP PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST PUSH2 0x1C4 PUSH2 0x3D8 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 DUP3 DUP2 MSTORE PUSH1 0x20 ADD SWAP2 POP POP PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST PUSH2 0x226 PUSH1 0x4 DUP1 CALLDATASIZE SUB PUSH1 0x40 DUP2 LT ISZERO PUSH2 0x1F0 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST DUP2 ADD SWAP1 DUP1 DUP1 CALLDATALOAD PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND SWAP1 PUSH1 0x20 ADD SWAP1 SWAP3 SWAP2 SWAP1 DUP1 CALLDATALOAD SWAP1 PUSH1 0x20 ADD SWAP1 SWAP3 SWAP2 SWAP1 POP POP POP PUSH2 0x3DE JUMP JUMPDEST STOP JUMPDEST PUSH1 0x1 SLOAD DUP2 JUMP JUMPDEST PUSH1 0x0 PUSH1 0x4 PUSH1 0x0 DUP4 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 SLOAD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST DUP1 PUSH1 0x0 SLOAD PUSH1 0x2 SLOAD PUSH1 0x1 SLOAD DUP4 MUL ADD GT ISZERO PUSH2 0x28F JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST PUSH1 0x0 PUSH1 0x1 SLOAD DUP4 MUL SWAP1 POP DUP1 PUSH1 0x3 PUSH1 0x0 DUP7 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 PUSH1 0x0 DUP3 DUP3 SLOAD ADD SWAP3 POP POP DUP2 SWAP1 SSTORE POP PUSH1 0x1 SLOAD PUSH1 0x3 PUSH1 0x0 DUP7 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 SLOAD DUP2 PUSH2 0x32F JUMPI INVALID JUMPDEST DIV PUSH1 0x4 PUSH1 0x0 DUP7 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 DUP2 SWAP1 SSTORE POP DUP1 PUSH1 0x2 PUSH1 0x0 DUP3 DUP3 SLOAD ADD SWAP3 POP POP DUP2 SWAP1 SSTORE POP POP POP POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x3 PUSH1 0x0 DUP4 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 SLOAD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x2 SLOAD DUP2 JUMP JUMPDEST PUSH1 0x0 SLOAD DUP2 JUMP JUMPDEST DUP1 PUSH1 0x3 PUSH1 0x0 DUP5 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 PUSH1 0x0 DUP3 DUP3 SLOAD SUB SWAP3 POP POP DUP2 SWAP1 SSTORE POP PUSH1 0x1 SLOAD PUSH1 0x3 PUSH1 0x0 DUP5 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 SLOAD DUP2 PUSH2 0x475 JUMPI INVALID JUMPDEST DIV PUSH1 0x4 PUSH1 0x0 DUP5 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 DUP2 SWAP1 SSTORE POP DUP1 PUSH1 0x2 PUSH1 0x0 DUP3 DUP3 SLOAD SUB SWAP3 POP POP DUP2 SWAP1 SSTORE POP POP POP JUMP INVALID LOG2 PUSH5 0x6970667358 0x22 SLT KECCAK256 0xBE MSIZE PUSH29 0x7E4D1B30B1060187581DB11E1E228E8F904C8BE8D78A7B423225A81BAF PUSH5 0x736F6C6343 STOP MOD MOD STOP CALLER \",\r\n"
            + "\t\"sourceMap\": \"79:1838:0:-:0;;;210:7;183:34;;316:4;286:34;;458:1;422:37;;79:1838;5:9:-1;2:2;;;27:1;24;17:12;2:2;79:1838:0;;;;;;;\"\r\n"
            + "}";

    public static final String FUNC_BUY_ALICOINS = "buy_alicoins";

    public static final String FUNC_EQUITY_IN_ALICOINS = "equity_in_alicoins";

    public static final String FUNC_EQUITY_IN_USD = "equity_in_usd";

    public static final String FUNC_MAX_ALICOINS = "max_alicoins";

    public static final String FUNC_SELL_ALICOINS = "sell_alicoins";

    public static final String FUNC_TOTAL_ALICOINS_BOUGHT = "total_alicoins_bought";

    public static final String FUNC_USD_TO_ALICOINS = "usd_to_alicoins";

    @Deprecated
    protected Alicoin_ico(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Alicoin_ico(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Alicoin_ico(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Alicoin_ico(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> buy_alicoins(String investor, BigInteger usd_invested) {
        final Function function = new Function(
                FUNC_BUY_ALICOINS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(investor), 
                new org.web3j.abi.datatypes.generated.Uint256(usd_invested)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Uint256> equity_in_alicoins(String investor) {
        final Function function = new Function(
                FUNC_EQUITY_IN_ALICOINS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(investor)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Uint256> equity_in_usd(String investor) {
        final Function function = new Function(
                FUNC_EQUITY_IN_USD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(investor)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

//    public RemoteCall<TransactionReceipt> max_alicoins() {
//        final Function function = new Function(
//                FUNC_MAX_ALICOINS,
//                Arrays.<Type>asList(),
//                Collections.<TypeReference<?>>emptyList());
//        return executeRemoteCallTransaction(function);
//    }

    public RemoteCall<Uint256> max_alicoins() {
        final Function function = new Function(
                FUNC_MAX_ALICOINS,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> sell_alicoins(String investor, BigInteger alicoins_sold) {
        final Function function = new Function(
                FUNC_SELL_ALICOINS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(investor), 
                new org.web3j.abi.datatypes.generated.Uint256(alicoins_sold)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Uint256> total_alicoins_bought() {
        final Function function = new Function(
                FUNC_TOTAL_ALICOINS_BOUGHT, 
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Uint256> usd_to_alicoins() {
        final Function function = new Function(
                FUNC_USD_TO_ALICOINS, 
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    @Deprecated
    public static Alicoin_ico load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Alicoin_ico(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Alicoin_ico load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Alicoin_ico(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Alicoin_ico load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Alicoin_ico(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Alicoin_ico load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Alicoin_ico(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Alicoin_ico> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Alicoin_ico.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Alicoin_ico> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Alicoin_ico.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Alicoin_ico> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Alicoin_ico.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Alicoin_ico> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Alicoin_ico.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
