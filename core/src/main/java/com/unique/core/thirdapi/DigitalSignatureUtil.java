package com.unique.core.thirdapi;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.unique.core.bo.DigitalSignatureBO;
import com.unique.core.enums.SystemCodeEnum;
import com.unique.core.exception.BaseException;
import lombok.SneakyThrows;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @author UNIQUE
 * @date 2024/01/05
 */
public class DigitalSignatureUtil {
    /**
     * 加密方式RSA非对称加密
     */
    private static final String ALGORITHM_TYPE = "RSA";
    /**
     * 加密算法
     */
    private static final String ALGORITHM = "SHA256withRSA";
    /**
     * 长度
     */
    private static final int KEY_SIZE = 2048;
    /**
     * AES加密
     */
    private static final String AES = "AES";
    /**
     * 编码方式
     */
    private static final String UTF8 = "UTF-8";
    /**
     * 数据填充方式
     */
    private static final String CIPHERALGORITHM = "AES/ECB/PKCS5Padding";
    /**
     * 加密长度
     */
    private static final int AES_KEY_SIZE = 128;


    /**
     * 生成密钥对，并以字符串形式返回
     *
     * @return String[] 包含公钥和私钥的字符串数组
     * @throws NoSuchAlgorithmException 如果指定的算法无效
     */
    public static String[] generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM_TYPE);
        keyPairGenerator.initialize(KEY_SIZE);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        String publicKeyStr = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        String privateKeyStr = Base64.getEncoder().encodeToString(privateKey.getEncoded());
        String[] data = {publicKeyStr, privateKeyStr};
        return data;
    }

    /**
     * 对数据进行数字签名
     *
     * @param data          要签名的数据
     * @param privateKeyStr 私钥字符串
     * @return String 签名结果（Base64编码）
     * @throws NoSuchAlgorithmException 指定的算法无效
     * @throws InvalidKeyException      私钥无效
     * @throws SignatureException       签名过程出现错误
     */
    public static String sign(String data, String privateKeyStr) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, InvalidKeySpecException {
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyStr);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_TYPE);
        PrivateKey privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(privateKeyBytes));
        Signature signature = Signature.getInstance(ALGORITHM);
        signature.initSign(privateKey);
        signature.update(data.getBytes());
        byte[] digitalSignature = signature.sign();
        String sign = Base64.getEncoder().encodeToString(digitalSignature);
        return sign;
    }

    /**
     * 验证数字签名
     *
     * @param data         要验证的数据
     * @param signature    签名结果（Base64编码）
     * @param publicKeyStr 公钥字符串
     * @return boolean 如果签名有效，则为true；否则为false
     * @throws NoSuchAlgorithmException 指定的算法无效
     * @throws InvalidKeyException      公钥无效
     * @throws SignatureException       验证过程出现错误
     */
    public static boolean verify(String data, String signature, String publicKeyStr) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, InvalidKeySpecException {
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyStr);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_TYPE);
        PublicKey publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(publicKeyBytes));
        Signature verification = Signature.getInstance(ALGORITHM);
        verification.initVerify(publicKey);
        verification.update(data.getBytes());
        byte[] decodedSignature = Base64.getDecoder().decode(signature);
        boolean verify = verification.verify(decodedSignature);
        return verify;
    }

    /**
     * 使用私钥加密数据
     *
     * @param data          要加密的数据
     * @param privateKeyStr 私钥字符串
     * @return String 加密后的数据（Base64编码）
     * @throws NoSuchAlgorithmException  指定的算法无效
     * @throws InvalidKeyException       私钥无效
     * @throws NoSuchPaddingException    找不到指定的填充模式
     * @throws IllegalBlockSizeException 加密时数据块大小无效
     * @throws BadPaddingException       加密时发生填充错误
     */
    public static String encrypt(String data, String privateKeyStr) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyStr);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_TYPE);
        PrivateKey privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(privateKeyBytes));
        Cipher cipher = Cipher.getInstance(ALGORITHM_TYPE);
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] encryptedDataBytes = cipher.doFinal(data.getBytes());
        String encryptData = Base64.getEncoder().encodeToString(encryptedDataBytes);
        return encryptData;
    }

    /**
     * 使用公钥解密数据
     *
     * @param encryptedData 加密后的数据（Base64编码）
     * @param publicKeyStr  公钥字符串
     * @return String 解密后的数据
     * @throws NoSuchAlgorithmException  指定的算法无效
     * @throws InvalidKeyException       公钥无效
     * @throws NoSuchPaddingException    找不到指定的填充模式
     * @throws IllegalBlockSizeException 解密时数据块大小无效
     * @throws BadPaddingException       解密时发生填充错误
     */
    public static String decrypt(String encryptedData, String publicKeyStr) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyStr);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_TYPE);
        PublicKey publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(publicKeyBytes));
        Cipher cipher = Cipher.getInstance(ALGORITHM_TYPE);
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] encryptedDataBytes = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedDataBytes = cipher.doFinal(encryptedDataBytes);
        String decryptData = new String(decryptedDataBytes);
        return decryptData;
    }


    /**
     * 生成AES秘钥对
     */
    public static String aesGenerateKeyPair() throws NoSuchAlgorithmException {
        // 生成对称密钥
        KeyGenerator keyGen = KeyGenerator.getInstance(AES);
        keyGen.init(AES_KEY_SIZE);
        SecretKey secretKey = keyGen.generateKey();
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }

    /**
     * AES加密
     *
     * @param content   要加密的内容
     * @param secretKey 秘钥
     * @return 加密后的内容
     */
    public static String aesEncrypt(String content, String secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] encodeFormat = secretKey.getBytes();
        SecretKeySpec key = new SecretKeySpec(encodeFormat, AES);
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(CIPHERALGORITHM);
        // 加密内容进行编码
        byte[] byteContent = content.getBytes(UTF8);
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, key);
        // 正式执行加密操作
        byte[] result = cipher.doFinal(byteContent);
        return Hex.encodeHexString(result);
    }

    public static String aesDecrypt(String content, String secretKey) throws DecoderException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        // 密文使用Hex解码
        byte[] byteContent = Hex.decodeHex(content.toCharArray());
        byte[] encodeFormat = secretKey.getBytes();
        SecretKeySpec key = new SecretKeySpec(encodeFormat, AES);
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(AES);
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, key);
        // 正式执行解密操作
        byte[] result = cipher.doFinal(byteContent);
        return new String(result, UTF8);
    }





    /**
     * 加密数据
     * @param baseMap
     * @param privateKeyStr
     * @return {@link Map}<{@link String}, {@link Object}>
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws NoSuchPaddingException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws InvalidKeySpecException
     */
    @SneakyThrows
    public static Map<String, Object> encryptData(Map<String, Object> baseMap, String privateKeyStr) {
        Map<String, Object> bodyMap = new HashMap<>();
        Map<String, Object> sortMap = baseMap.keySet().stream().sorted().collect(Collectors.toMap(k -> k, v -> baseMap.get(v)));
        String baseData = JSON.toJSONString(sortMap);
        //加密示例
        String secretKey = aesGenerateKeyPair();
        System.out.println("对称秘钥: + secretKey");
        String data = aesEncrypt(baseData,secretKey);
        System.out.println("加密后真实数据:" + data);
        String encryptSecretKey = encrypt(secretKey, privateKeyStr);
        System.out.println("加密后的对称密钥数据: + encryptSecretKey");
        String sign = sign(encryptSecretKey, privateKeyStr);
        System.out.println("签名:" + sign);
        //重组反回数据
        bodyMap.put("operate", "update");
        bodyMap.put("sign", sign);
        bodyMap.put("data", data);
        bodyMap.put("encryptSecretKey", encryptSecretKey);
        return bodyMap;
    }
    /**
     * 解析签名数据
     * @param signatureBO 入参
     * @param publicKeyStr 公钥字符串
     * @return {@link String} 解析后的值
     */
    public static String decryptSignCheck(DigitalSignatureBO signatureBO, String publicKeyStr) {
        try {
            // 1.调用verify方法验证签名是否合法
            boolean verifyFlag = verify(signatureBO.getEncryptSecretKey(), signatureBO.getSign(), publicKeyStr);
            if (verifyFlag) {
                // 2.调用decrypt方法解密数据
                String secretKey = decrypt(signatureBO.getEncryptSecretKey(), publicKeyStr);
                System.out.println("对称秘钥:" + secretKey);
                String originalData = aesDecrypt(signatureBO.getData(), secretKey);
                System.out.println("原始数据: "+ originalData);
                return originalData;
            }
        } catch (NoSuchAlgorithmException | SignatureException | InvalidKeyException | InvalidKeySpecException |
                 NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | DecoderException |
                 UnsupportedEncodingException e) {
            throw new BaseException(SystemCodeEnum.DIGITAL_SIGNATURE_ERROR);
        }
        return StrUtil.EMPTY;
    }
}
