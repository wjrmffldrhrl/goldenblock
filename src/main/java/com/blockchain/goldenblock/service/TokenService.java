package com.blockchain.goldenblock.service;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.blockchain.goldenblock.domain.entity.Student;
import com.blockchain.goldenblock.domain.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;

import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.protocol.Web3j;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.PersonalListAccounts;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
import org.web3j.crypto.Wallet;
import org.web3j.crypto.WalletFile;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthCall;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.http.HttpService;

@Service
@Transactional
public class TokenService {

    @Autowired
    private StudentRepository userInfoRepository;

    // Token contract address

    private String goldenTokenAddress = "0x412bFC8ac9e23d2F662a9cb79eD91F5e9EeB7581";

    private String networkAddress = "HTTP://127.0.0.1:7545";

    private Web3j web3j;

    private Admin admin;
    List<String> addressList;

    // Connect blockchain server with web3j
    public TokenService() throws Exception {
        web3j = Web3j.build(new HttpService(networkAddress));
        admin = Admin.build(new HttpService(networkAddress));

        PersonalListAccounts personalListAccounts = admin.personalListAccounts().send();

        addressList = personalListAccounts.getAccountIds();

    }

    // no transaction contract
    private List<Type> viewFunction(String functionName, List<Type> inputParameters,
                                    List<TypeReference<?>> outputParameters) throws IOException {

        Function function = new Function(functionName, inputParameters, outputParameters);

        System.out.println("function : " + function);

        // send transaction from address[0] to contract
        Transaction transaction = Transaction.createEthCallTransaction(addressList.get(0), goldenTokenAddress,
                FunctionEncoder.encode(function));

        EthCall ethCall = web3j.ethCall(transaction, DefaultBlockParameterName.LATEST).send();


        List<Type> decode = FunctionReturnDecoder.decode(ethCall.getResult(), function.getOutputParameters());

        return decode;
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
                Transaction.DEFAULT_GAS, null, goldenTokenAddress, FunctionEncoder.encode(function));


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

    // Get total supplied token
    public String totalSupply() throws Exception {

        List<Type> decode = viewFunction("totalSupply", Collections.emptyList(),
                Arrays.asList(new TypeReference<Uint256>() {
                }));

        return decode.get(0).getValue().toString();

    }


}