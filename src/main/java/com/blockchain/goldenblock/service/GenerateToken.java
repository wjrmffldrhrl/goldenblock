


@Service
public class GenerateToken {

    @AutoWired
    private Web3j web3;

    String web3jAddress = "http://127.0.0.1:7545";
    String accountAddress = "0xc5Bb3da8f70cB2C8074F5B04c3d9494E5fB9cd43";
    String privateKey = "073a17d918cf30ce34becda54541da8b82dad875bd0888dbda94434ef3f16b6c";
    Stirng contractAddress = "0x3327C194762D059D4e89563680e3674Ed4B26fCc";


    public void GenerateToke() {
        web3j = Web3j.build(new HttpService(web3jAddress));
        Web3ClientVersion web3ClientVersion = web3.web3ClientVersion(accountAddres).send();
        String clientVersion = web3ClientVersion.getWeb3ClientVersion();

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