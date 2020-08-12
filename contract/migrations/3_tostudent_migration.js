const TokenToStudent = artifacts.require("TokenToStudent");

module.exports = function(deployer) {
  deployer.deploy(TokenToStudent);
};
