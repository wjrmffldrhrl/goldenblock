package com.blockchain.goldenblock.service;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Uint;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.PersonalListAccounts;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthCall;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.http.HttpService;


public class GenerateToken {

	private String armaTokenAddress = "0x3327C194762D059D4e89563680e3674Ed4B26fC";

    private String networkAddress = "http://127.0.0.1:7545";

    private Web3j web3j;

    private Admin admin;
    List<String> addressList;

    // Connect blockchain server with web3j
    public GenerateToken() throws Exception {
        web3j = Web3j.build(new HttpService(networkAddress));
        admin = Admin.build(new HttpService(networkAddress));

        PersonalListAccounts personalListAccounts = admin.personalListAccounts().send();

        addressList = personalListAccounts.getAccountIds();

    }


	private void transactionFunction(String functionName, List<Type> inputParameters,

	List<TypeReference<?>> outputParameters) {




// Create contract function
Function function = new Function(functionName, inputParameters, outputParameters);

// For the check nonce
EthGetTransactionCount ethGetTransactionCount = null;

// Get Transaction nonce
try {

	ethGetTransactionCount = web3j.ethGetTransactionCount(addressList.get(0), DefaultBlockParameterName.LATEST)
			.sendAsync().get();

} catch (InterruptedException | ExecutionException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}


BigInteger nonce = ethGetTransactionCount.getTransactionCount();

// Create Transaction with nonce
Transaction transaction = Transaction.createFunctionCallTransaction(addressList.get(0), nonce,
		Transaction.DEFAULT_GAS, null, armaTokenAddress, FunctionEncoder.encode(function));


try {
	// Sent transaction
	web3j.ethSendTransaction(transaction).send();
} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}

// ledger에 쓰여지기 까지 기다리기.
try {
	Thread.sleep(2000);
} catch (InterruptedException e) {
	e.printStackTrace();
}

}



    // 계좌 잠금해제
    // PersonalUnlockAccount personalUnlockAccount = web3j.personalUnlockAccount(accountAddress, privateKey).send();
    //     if (personalUnlockAccount.accountUnlocked()) {
    //     // send a transaction
    // }

    // public static void main() {

    //     List<Type> inputParameters = Arrays.asList(new Uint8(param)); 
    //     List<TypeReference<?>> outputParameters = Arrays.asList(new TypeReference<Type>() {});
    
    //     Function function = new Function("setValue", inputParameters, outputParameters);
    //     String encodedFunction = FunctionEncoder.encode(function);
    
    //     EthSendTransaction ethCall = null;
    //     try {
    //         //Nonce
    //         EthGetTransactionCount ethGetTransactionCount = web3j.ethGetTransactionCount(
    //             accountAddres, DefaultBlockParameterName.LATEST).sendAsync().get();
    //         BigInteger nonce = e.getTransactionCount();
    //         log.info("==NONCE:" + nonce);
    
    //         //Run
    //         ethCall = web3j.ethSendTransaction(
    //             Transaction.createFunctionCallTransaction(
    //                     accountAddres,
    //                     nonce, //or nullL
    //                     this.getGasPrice(), //gasPrice
    //                     BigInteger.valueOf(27000), //gasLimit
    //                     contractAddress,
    //                     encodedFunction)
    //         ).sendAsync().get();
    //     }catch (Exception e) {
    //         e.printStackTrace();
    //     }
    
    // String transactionHash = ethCall.getTransactionHash();

    // }
}