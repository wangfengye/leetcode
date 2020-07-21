package utils;

//import sun.misc.BASE64Decoder;


import javax.crypto.Cipher;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author maple on 2019/3/21 14:59.
 * @version v1.0
 * @see 1040441325@qq.com
 * 微信小程序验证信息解密
 */
public class WXBizDataCrypt {
    public static void main(String[] args) throws Exception {
        String appId = "wx8188cd6831a6c7b8";
        String sessionKey = "FD4udedT7I6SgCmot6dmEw==";
        String encryptedData = "TlGd+HuB/T6J7BUoKXq3lRwX5EIzu7K7QXn50LBBkHLHqt3fSG89Y8jI2MGgJpKuv/VwbIY0hO/zqmpUobBm3S7Rqv9rjbz7/QM4Q0itbiTpRCG48kREKjg66G1eRFlzEcwA6ZcYqMAbhEc90jyFarrvTCcR0i4Wq1inA1Wgmduv12t6/2RgkcG1sYY7Svq/E3ISn3oGI6vEtL6nlzZKgtSPpnuB1O/z0Qfzx8rVeXYR0KMWbIjvI7i4ebsnZHBiEr3nn6BONJHdFify3D1z4EKX9su4iiczqEaah3qp38T3W0sBQbFZ6O0RJU1ng5sZfAudQFncbHB2RX9+Ep7vTtQUNzdq8abTLDPY0vlTXw//Z/JdyJtAjlllYXoIANa65z2EKvOanoVwSpNEx8rYmPwWWI7rCDo4yvPe8bynPzeNT2g2uENPesp+SVtCs+KN+WdslfUVyUZbIJRW9eZ2X3fO83yEncWn0BFWVQHkGqW9MNsNYMPEE7su4Js6NmM/61pLtHvpFE5Xt/ElEkl2Ug==";
        String iv = "wTqSMgSbM1l4vDzhtiDTcQ==";
        WXBizDataCrypt wxBizDataCrypt = new WXBizDataCrypt(appId, sessionKey);
        System.out.println(wxBizDataCrypt.decrypt(encryptedData, iv));
         String a = "\u5639";
         char[] utf8 = new char[a.length()];
         a.getChars(0,a.length(),utf8,0);
         String b = utf8.toString();
        a((Boolean) null);

    }
    public static void a(Integer i){
        System.out.println("a");
    }
    public static void a(Boolean i){
        System.out.println("b");
    }
    public static String string2Unicode(String string) {
        StringBuffer unicode = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
            // 取出每一个字符
            char c = string.charAt(i);
            // 转换为unicode
            unicode.append("\\u" + Integer.toHexString(c));
        }

        return unicode.toString();
    }

    public static String unicode2String(String unicode) {
        StringBuffer string = new StringBuffer();
        String[] hex = unicode.split("\\\\u");

        for (int i = 1; i < hex.length; i++) {
            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 16);
            // 追加成string
            string.append((char) data);
        }

        return string.toString();
    }


    private String appId;

    private String sessionKey;

    public WXBizDataCrypt(String appId, String sessionKey) {
        this.appId = appId;
        this.sessionKey = sessionKey;
    }

    /**
     * 1.对称解密使用的算法为 WXBizDataCrypt-128-CBC，数据采用PKCS#7填充。
     * 2.对称解密的目标密文为 Base64_Decode(encryptedData)。
     * 3.对称解密秘钥 aeskey = Base64_Decode(session_key), aeskey 是16字节。
     * 4.对称解密算法初始向量 为Base64_Decode(iv)，其中iv由数据接口返回。
     *
     * @param
     * @throws Exception
     */
    public String decrypt(String encryptedData, String iv) throws Exception {
        String jsonStr = new String("");
        try {
           /* BASE64Decoder base64Decoder = new BASE64Decoder();
            *//**
             * 小程序加密数据解密算法
             * https://developers.weixin.qq.com/miniprogram/dev/api/signature.html#wxchecksessionobject
             * 1.对称解密的目标密文为 Base64_Decode(encryptedData)。
             * 2.对称解密秘钥 aeskey = Base64_Decode(session_key), aeskey 是16字节。
             * 3.对称解密算法初始向量 为Base64_Decode(iv)，其中iv由数据接口返回。
             *//*
            byte[] encryptedByte = base64Decoder.decodeBuffer(encryptedData);
            byte[] sessionKeyByte = base64Decoder.decodeBuffer(this.sessionKey);
            byte[] ivByte = base64Decoder.decodeBuffer(iv);
            *//**
             * 以下为AES-128-CBC解密算法
             *//*
            SecretKeySpec skeySpec = new SecretKeySpec(sessionKeyByte, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(ivByte);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);
            byte[] original = cipher.doFinal(encryptedByte);
            jsonStr = new String(original);*/
        } catch (Exception ex) {
            throw new Exception("Illegal Buffer");
        }
        return jsonStr;
    }
}