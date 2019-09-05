package javaBase;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author maple on 2019/9/5 8:52.
 * @version v1.0
 * @see 1040441325@qq.com
 */
public class StringTest {
    /**
     * utf8是单字节为编码单元，在网络传输时，不存在字节序列问题,一般首字节表示单个字符长度.
     * utf16需要字节序,因为两个字节表示一个字符,可能导致解码错误.
     * 字节序问题本质是大小端问题.
     * 大端和小端的问题:
     * 对于整型、长整型等数据类型，Big endian 认为第一个字节是最高位字节（按照从低地址到高地址的顺序存放数据的高位字节到低位字节）；而 Little endian 则相反，它认为第一个字节是最低位字节（按照从低地址到高地址的顺序存放据的低位字节到高位字节）
     * java中获取stringbytes长度会多出两个byte,就是字节序标识.
     *
     * utf-8 优势,单字节为编码单元,表示基本字符时,长度为1个byte,相比utf-16(两个byte)节省大量空间
     * String.length()存在问题,对于四字节表示的字符,长度会被识别为2,(目前只有字符表情,以及极少数生僻字会出现该情况,一般不需要考虑)
     *
     * Q: string 最大长度.
     * 分量中情况: 常量String,编译程序限制其byte最大为65535,因为其编译期常量StringInfo结构中,定义的记录长度的数据类型,支持的最大长度为65535,编译时会检测长度超出会抛出异常.
     *  同时常量还受到整个栈区大小的限制
     *  一个小bug,在检测时有部分使用 <65535判断,有的使用>65535判断,及某些情况下,要保证其<=65534
     *  动态分配的String. 使用char数组保存,受到数组最大长度Integer.length,限制,同时数组还预留一部位位置给头信息,实际上应该更小,
     *  同时也受到堆区大小的限制.
     */
    public static void main(String[] args) {
        Properties initProp = new Properties(System.getProperties());
        System.out.println("当前系统编码:" + initProp.getProperty("file.encoding"));
        System.out.println("当前系统语言:" + initProp.getProperty("user.language"));
        String str = "\uD808\uDF45";
        System.out.println(str);
        System.out.println("UTF-8-bytes: " + str.getBytes().length);
        try {
            System.out.println("UTF-16-bytes: " + str.getBytes("UTF-16").length);//显示长度4,其实是2,因为首位有两个byte 0xFeff,表示utf-16字节序
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("chars:" + str.toCharArray().length);
        System.out.println("string length:" + str.length());
        String str1 = "a";
        System.out.println(str1);
        System.out.println("UTF-8-bytes: " + str1.getBytes().length);
        try {
            System.out.println("UTF-16-bytes: " + str1.getBytes("UTF-16").length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("chars:" + str1.toCharArray().length);
        System.out.println("string length:" + str1.length());

    }

    private static byte[] getBytes(char[] chars) {
        Charset cs = Charset.forName("UTF-8");
        CharBuffer cb = CharBuffer.allocate(chars.length);
        cb.put(chars);
        cb.flip();
        ByteBuffer bb = cs.encode(cb);

        return bb.array();

    }

}
