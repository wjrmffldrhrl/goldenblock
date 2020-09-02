pragma solidity <0.8.0;

import "../node_modules/@openzeppelin/contracts/token/ERC20/ERC20.sol";
import "../node_modules/@openzeppelin/contracts/access/Ownable.sol";

contract GenerateRank is ERC20, Ownable {
    
    constructor() public ERC20("Rank", "RNK") {
        _mint(msg.sender, 10000);
    }
    
    //랭킹포인트 발행
    function rankMint(address to, uint256 amount) public returns (bool){
        _mint(to, amount);
    }
    
   //랭킹 포인트 이동
    function sendRank(address from, address to, uint256 amount) public {
        _transfer(from, to, amount);
    }

    //랭킹 포인트 삭제
    function rankBurn(address sender, uint256 amount) public{
        _burn(sender, amount);
    }
    
}