pragma solidity >=0.4.21 <0.7.0;

import "@openzeppelin/contracts/token/ERC20/ERC20.sol";
import "@openzeppelin/contracts/access/Ownable.sol";


contract GenerateToken is ERC20, Ownable{
    constructor() public ERC20("Golden", "GLD") {
        _mint(msg.sender, 1000);
    }

    function payment(address _to, uint256 _amount) public returns (bool){
        // reciept validate
        _mint(_to, _amount);
    }
