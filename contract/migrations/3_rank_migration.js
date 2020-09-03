const GenerateRank = artifacts.require("GenerateRank");

module.exports = function(deployer) {
  deployer.deploy(GenerateRank);
};
