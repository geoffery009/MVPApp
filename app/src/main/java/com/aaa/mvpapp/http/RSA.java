package com.aaa.mvpapp.http;


import android.text.TextUtils;

import org.apache.commons.codec.binary.Base64;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;

/**
 * 加解密
 * @author wei sun
 * Created by win7 on 2016/11/19.
 *
 */
public class RSA {

    //私钥
    private static final String myselfstockPriKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKQ76ZA5xga9c6OG\n" +
            "qm+8TI3VtV0ErbNcI8Tt9KFMh9j9BRfoTlFQX71urRNGd3jXHDygEOINqPhy3DaF\n" +
            "ZQcZzm44tR+c+pllxxljbWiYZdPrxdwfDg9BAeNbFmgwSNZE+VlNSMXHFIv4beaw\n" +
            "cYVRtvucutDobFxsh54rolxeS7/JAgMBAAECgYEAky2pyvkrUKD4/6PQG2AIztak\n" +
            "uF5X97NrzrBcmSxHVZqxtNIXVWGM2utTKUHuERndESt01c/eDACK/kUe23Ux+z9G\n" +
            "0izh92SPwlppwLCjjjvJb+8GvHRqX5aJIBKT9fVe0rx3ajFqSBcC+qaTwi2r1J3w\n" +
            "iPU6EpWQ53BCf0DRMu0CQQDPlcrr3EQ7m+B10nvQMVNKKrxYwTUT8upndShU1h7p\n" +
            "SYu1Pq7CUmBTcL6SMkQJ9WNzItdIVZWLecia+rVej4SLAkEAyonFqn8sFIfjPs9p\n" +
            "8MfWM+4KHQnc/b1PLLOejxx+57hl9xaF2hrhNhzDpgB78tmbJ1XJS55Z6MabLFB1\n" +
            "u9pTewJAfiP3+vsOO2qtKuuMcSaIBjmR2h0Ns+GYruVybJrwjbIzQx+j8lE8V3fb\n" +
            "VdtVnPeQRxaU20+mX+rRC9vs+lkboQJAT+DsQ2TqhqJdPm1hE+RMl6h+9proPG6I\n" +
            "JlIk675KUqtIE54fZjiJr+TCSNsSB2JJLcdIn3kxbnu9wUluVYsytwJAJXlS8XJF\n" +
            "J/y6Ed567PxJU0Aa0fG2otZOHaL9Yqeo87la3XL9bK2P3a7G5YV3iDVQ74b8HfWp\n" +
            "KLAjMR6z1l8GTg==";
    //公钥
    private static final String serverstockPubKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDhZPyhuywk0yDHHMApntPPJIhG\n" +
            "bEdOMySxDggrAGzyee5wee3pE9JdE+jYb2V67nctbtCPNZOgQNokqvN2kwA74d/L\n" +
            "fa1SWw7Ar8wCLP6MJJbD4R4gy5h1Dfdh7VCj3XsXPw71vzHcYHlSYS1OI4FEah24\n" +
            "izvPf8qati2jcVtaZwIDAQAB";


    private static final String transformation = "RSA/ECB/PKCS1Padding";

    /**
     * RSA最大加密明文大小(117)
     */
    public static final int MAX_ENCRYPT_BLOCK = 117;
    /**
     * RSA最大解密密文大小(128)
     */
    public static final int MAX_DECRYPT_BLOCK = 128;

    /** */
    /**
     * 获取公钥的key
     */
    public static final String PUBLIC_KEY = "RSAPublicKey";

    /** */
    /**
     * 获取私钥的key
     */
    public static final String PRIVATE_KEY = "RSAPrivateKey";

    /**
     * 签名算法
     */
    public static final String SIGNATURE_ALGORITHM = "SHA1withRSA";

    /**
     * 缓存密钥
     */
    private static final Map<String, Object> keyMap = new HashMap<String, Object>();

    /**
     * 加载指定路径证书文件，获取公钥
     *
     * @return 公钥对象
     * @throws RuntimeException
     * @paramkeyPath证书文件路径
     */
    public static PublicKey loadPublicKey(String keyPath)
            throws RuntimeException {
        X509Certificate cert = certDispose(keyPath);
        PublicKey key = cert.getPublicKey();
        keyMap.put(PUBLIC_KEY, key);
        return key;
    }

    /**
     * 读取X509证书
     *
     * @param file
     * @return  结果
     * @throws SecurityException
     */
    private static X509Certificate certDispose(String file)
            throws SecurityException {
        InputStream input = null;
        X509Certificate x509certificate;
        try {
            input = new BufferedInputStream(new FileInputStream(file));
            CertificateFactory certificatefactory = CertificateFactory
                    .getInstance("X.509");

            x509certificate = (X509Certificate) certificatefactory
                    .generateCertificate(input);

            if (null != input)
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        } catch (Exception e) {
            throw new SecurityException("读取证书失败", e);
        } finally {
            if (null != input) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return x509certificate;
    }

    /**
     * 加密
     *
     * @return  结果
     * @throws RuntimeException
     * @paramkey密钥
     * @paramdata源数据bytes
     */
    public static String encrypt(String pubKeyStr, String data)
            throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        byte[] encodedKey = Base64.decodeBase64(pubKeyStr.getBytes());
        PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
        return encrypt(pubKey, data);
    }

    /**
     * 加密
     *
     * @param key 密钥
     * @return  结果
     * @throws RuntimeException
     * @paramdata源数据bytes
     */
    public static String encrypt(Key key, String dataStr)
            throws RuntimeException {
        try {
            byte[] data = dataStr.getBytes("UTF-8");
            Cipher cipher = Cipher.getInstance(transformation);
            cipher.init(Cipher.ENCRYPT_MODE, key);

            int outputSize = cipher.getOutputSize(data.length);// 获得加密块加密后块大小
            int leavedSize = data.length % MAX_ENCRYPT_BLOCK;
            int blocksSize = leavedSize != 0 ? data.length / MAX_ENCRYPT_BLOCK
                    + 1 : data.length / MAX_ENCRYPT_BLOCK;
            byte[] raw = new byte[outputSize * blocksSize];
            int i = 0;
            while (data.length - i * MAX_ENCRYPT_BLOCK > 0) {
                if (data.length - i * MAX_ENCRYPT_BLOCK > MAX_ENCRYPT_BLOCK)
                    cipher.doFinal(data, i * MAX_ENCRYPT_BLOCK,
                            MAX_ENCRYPT_BLOCK, raw, i * outputSize);
                else
                    cipher.doFinal(data, i * MAX_ENCRYPT_BLOCK, data.length - i
                            * MAX_ENCRYPT_BLOCK, raw, i * outputSize);
                i++;
            }
            return new String(Base64.encodeBase64(raw));

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (ShortBufferException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     *
     * @param data 需要解密的bytes
     * @return  结果
     * @throws RuntimeException
     * @paramkey 密钥
     */
    public static String decrypt(String prikeyStr, String data)
            throws Exception {
        PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decodeBase64(prikeyStr.getBytes()));
        KeyFactory keyf = KeyFactory.getInstance("RSA");
        PrivateKey priKey = keyf.generatePrivate(priPKCS8);
        return decrypt(priKey, data);
    }

    /**
     * 解密
     *
     * @param key 密钥
     * @return  结果
     * @throws RuntimeException
     * @paramdata 需要解密的bytes
     */
    public static String decrypt(Key key, String dataStr)
            throws RuntimeException {
        try {
            byte[] data = Base64.decodeBase64(dataStr.getBytes());
            Cipher cipher = Cipher.getInstance(transformation);
            cipher.init(Cipher.DECRYPT_MODE, key);
            ByteArrayOutputStream bout = new ByteArrayOutputStream(64);
            int j = 0;

            while (data.length - j * MAX_DECRYPT_BLOCK > 0) {
                bout.write(cipher.doFinal(data, j * MAX_DECRYPT_BLOCK,
                        MAX_DECRYPT_BLOCK));
                j++;
            }
            return new String(bout.toByteArray(), "UTF-8");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成签名
     *
     * @return 签名bytes
     * @throws RuntimeException
     * @paramdata源数据bytes
     * @paramprikey私钥
     */
    public static String generateSignature(String data, String prikeyStr) {
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decodeBase64(prikeyStr.getBytes()));
            KeyFactory keyf = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);
            Signature sig = Signature.getInstance(SIGNATURE_ALGORITHM);
            sig.initSign(priKey);
//			sig.update(Base64.decodeBase64(data));
            sig.update(data.getBytes("UTF-8"));
            return new String(Base64.encodeBase64(sig.sign()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 验签
     *
     * @param signature 签名bytes
     * @return 验签结果
     * @throws RuntimeException
     * @paramdata 源数据bytes
     * @parampubKey公钥
     */
    public static boolean verifySignature1(String data, String pubKeyStr,
                                           String signature) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = Base64.decodeBase64(pubKeyStr.getBytes());
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
            Signature sig = Signature.getInstance(SIGNATURE_ALGORITHM);

            sig.initVerify(pubKey);

//			sig.update(Base64.decodeBase64(data));
            sig.update(data.getBytes("UTF-8"));
            return sig.verify(Base64.decodeBase64(signature.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }


    public static Map<String, String> encryptSignatureData(String data) {
        Map<String, String> resultMap = new HashMap<String, String>();
        // 加密
//		String encryptData = FangdaiSDKUtil.encrypt(xiangyustockPriKey, data);
        String encryptData = RSA.encryptData(data);
        // 加签
//		String signature = FangdaiSDKUtil
//				.generateSignature(encryptData, xiangyustockPriKey);
        String signature = RSA.generateSignature(data);
        resultMap.put("data", encryptData);
        resultMap.put("sign", signature);
        return resultMap;
    }

    /**
     * 加签
     *
     * @return  结果
     * @throws UnsupportedEncodingException
     * @throws RuntimeException
     * @paramdata
     */
    public static String generateSignature(String encryptData) {

        String signature = "";
        if (!TextUtils.isEmpty(encryptData)) {
//			PrivateKey xiangyustockPriKey = FangdaiSDKUtil.loadPrivateKey(PRIVATE_KEY_PATH,
//					PASSWORD);
            try {
                // 加签
                signature = RSA.generateSignature(encryptData,
                        myselfstockPriKey);

            } catch (RuntimeException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return signature;
    }

    /**
     * 加密
     *
     * @param data
     * @return  结果
     * @throws UnsupportedEncodingException
     * @throws RuntimeException
     */
    public static String encryptData(String data) {

        String encryptData = "";
        if (!TextUtils.isEmpty(data)) {
//			PublicKey xiangyustockPubKey = FangdaiSDKUtil.loadPublicKey(PUBLIC_KEY_PATH);
            try {

                encryptData = RSA.encrypt(serverstockPubKey, data);


            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return encryptData;
    }

    /**
     * 验签
     *
     * @param data
     * @param sign
     * @return  结果
     * @throws UnsupportedEncodingException
     * @throws RuntimeException
     */
    public static boolean verifySignature(String data, String sign) {

        boolean flag = false;
        if (!TextUtils.isEmpty(data) && !TextUtils.isEmpty(sign)) {
//			PublicKey xiangyustockPubKey = FangdaiSDKUtil.loadPublicKey(PUBLIC_KEY_PATH);
            try {
                // 验签
                flag = RSA.verifySignature1(data, serverstockPubKey, sign);
            } catch (RuntimeException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return flag;
    }

    /**
     * 解密
     *
     * @return  结果
     * @throws UnsupportedEncodingException
     * @throws RuntimeException
     * @paramdata
     */
    public static String decryptData(String encryptData) {

        String decryptData = "";
        if (!TextUtils.isEmpty(encryptData)) {
//			PrivateKey xiangyustockPriKey = FangdaiSDKUtil.loadPrivateKey(PRIVATE_KEY_PATH,
//					PASSWORD);
            try {
                // 解密
                decryptData = RSA.decrypt(myselfstockPriKey, encryptData);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return decryptData;
    }

}
