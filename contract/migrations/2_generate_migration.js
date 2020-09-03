const GenerateToken = artifacts.require("GenerateToken");

module.exports = function(deployer) {
  deployer.deploy(GenerateToken);
};
