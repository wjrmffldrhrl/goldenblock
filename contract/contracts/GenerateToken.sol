pragma solidity <0.8.0;

import "../node_modules/@openzeppelin/contracts/token/ERC20/ERC20.sol";
import "../node_modules/@openzeppelin/contracts/access/Ownable.sol";

contract GenerateToken is ERC20, Ownable {
    
    constructor() public ERC20("Golden", "GLD") {
        _mint(msg.sender, 10000);
    }
    
    function mint(address to, uint256 amount) public returns (bool){
        _mint(to, amount);
    }
    
   //골든 포인트 이동
    function sendToken(address from, address to, uint256 amount) public {
        _transfer(from, to, amount);
    }

    //골든 토큰 인출
    function burn(address sender, uint256 amount) public{
        _burn(sender, amount);
    }
    
}