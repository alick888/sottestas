// Alicoins ICO

// Version of compiler
pragma solidity >=0.4.22 <0.7.0;

contract alicoin_ico {
    
    // introducing the maximum number of Alicoin available for sale 
    uint public max_alicoins = 1000000;
    
    // introducing the USD to Alicoin conversion rate 
    uint public usd_to_alicoins = 1000;
    
    // introducing the total number of Alicoins that have been bought by the investors 
    uint public total_alicoins_bought = 0;
    
    // Mapping from the investor address to its equity in Alicoins and USD 
    mapping(address => uint) equity_alicoins;
    mapping(address => uint) equity_usd;
    
    // Checking if an investor can buy Alicoins 
    modifier can_buy_alicoins(uint usd_invested) {
        require(usd_invested * usd_to_alicoins + total_alicoins_bought <= max_alicoins);
        _;
    }
    
    // Getting the equity in Alicoins of an investor
    function equity_in_alicoins(address investor) external view returns (uint) {
        return equity_alicoins[investor];
    }
    
    // Getting the equity in Alicoins of an investor
    function equity_in_usd(address investor) external view returns (uint) {
        return equity_usd[investor];
    }
    
    // Buying Alicoins
    function buy_alicoins(address investor, uint usd_invested) external 
    can_buy_alicoins(usd_invested) {
        uint alicoins_bought = usd_invested * usd_to_alicoins;
        equity_alicoins[investor] += alicoins_bought;
        equity_usd[investor] = equity_alicoins[investor] / usd_to_alicoins;
        total_alicoins_bought += alicoins_bought;
    }
    
    // Selling Alicoins 
    function sell_alicoins(address investor, uint alicoins_sold) external {
        equity_alicoins[investor] -= alicoins_sold;
        equity_usd[investor] = equity_alicoins[investor] / usd_to_alicoins;
        total_alicoins_bought -= alicoins_sold;
    }
}