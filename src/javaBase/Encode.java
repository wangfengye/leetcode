package javaBase;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author maple on 2019/5/22 13:51.
 * @version v1.0
 * @see 1040441325@qq.com
 * UTf 编码转换
 */
public class Encode {
    public static String str2HexCode(String s) {
        StringBuilder builder = new StringBuilder();
        try {
            byte[] bytes = s.getBytes("unicode");
            for (int i = 0; i < bytes.length - 1; i += 2) {
                builder.append("\\u");
                String str = Integer.toHexString(bytes[i + 1] & 0xff);
                for (int j = str.length(); j < 2; j++) {
                    builder.append("0");
                }
                String str1 = Integer.toHexString(bytes[i] & 0xff);
                builder.append(str1);
                builder.append(str);

            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static String str2BinaryCode(String s) {
        StringBuilder builder = new StringBuilder();

        try {
            byte[] bytes = s.getBytes("unicode");
            for (int i = 0; i < bytes.length - 1; i += 2) {
                builder.append("\\u");
                String str = Integer.toBinaryString(bytes[i + 1] & 0xff);
                for (int j = str.length(); j < 8; j++) {
                    str = '0' + str;
                }
                String str1 = Integer.toBinaryString(bytes[i] & 0xff);
                for (int j = str.length(); j < 8; j++) {
                    str = '0' + str;
                }
                builder.append(str1);
                builder.append(str);

            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static String hex2Str(String s) {
        StringBuilder b = new StringBuilder();
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(s);
        char ch;
        while (matcher.find()) {
            //group 6728
            String group = matcher.group(2);
            //ch:'木' 26408
            ch = (char) Integer.parseInt(group, 16);
            b.append(ch);
        }
        return b.toString();
    }

    public static String binary2Str(String s) {
        StringBuilder b = new StringBuilder();
        Pattern pattern = Pattern.compile("(\\\\u([0-1]{12,16}))");
        Matcher matcher = pattern.matcher(s);
        char ch;
        while (matcher.find()) {
            String group = matcher.group(2);
            ch = (char) Integer.parseInt(group, 2);
            b.append(ch);
        }
        return b.toString();
    }

    public static void main(String[] args) {
        System.out.println(str2BinaryCode("心悦你"));
        System.out.println(str2HexCode("心悦你"));
        System.out.println(hex2Str("\\ufeff\\u5fc3\\u60a6\\u4f60"));
        System.out.println(binary2Str("\\u1111111011111111\\u101111111000011\\u110000010100110\\u100111101100000"));
    }
}
