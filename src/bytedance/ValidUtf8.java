package bytedance;

/**
 * @author maple on 2019/2/22 10:57.
 * @version v1.0
 * @see 1040441325@qq.com
 * UTF-8 编码验证
 * UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：
 * <p>
 * 对于 1 字节的字符，字节的第一位设为0，后面7位为这个符号的unicode码。
 * 对于 n 字节的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为0，后面字节的前两位一律设为10。剩下的没有提及的二进制位，全部为这个符号的unicode码。
 * 这是 UTF-8 编码的工作方式：
 * <p>
 * Char. number range  |        UTF-8 octet sequence
 * (hexadecimal)    |              (binary)
 * --------------------+---------------------------------------------
 * 0000 0000-0000 007F | 0xxxxxxx
 * 0000 0080-0000 07FF | 110xxxxx 10xxxxxx
 * 0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
 * 0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
 * 给定一个表示数据的整数数组，返回它是否为有效的 utf-8 编码。
 * <p>
 * 注意:
 * 输入是整数数组。只有每个整数的最低 8 个有效位用来存储数据。这意味着每个整数只表示 1 字节的数据。
 * <p>
 * 示例 1:
 * <p>
 * data = [197, 130, 1], 表示 8 位的序列: 11000101 10000010 00000001.
 * <p>
 * 返回 true 。
 * 这是有效的 utf-8 编码，为一个2字节字符，跟着一个1字节字符。
 */
public class ValidUtf8 {
    public boolean validUtf8(int[] data) {
        if (data.length == 0) return false;
        int index =0;
        while (index<data.length){
            if (data[index]>>7==0){
                index++;
            }else{
                int tmp =0;
                while ((data[index]>>(7-tmp)&1)==1){
                    tmp++;
                }

                if (tmp <= 1 &&tmp>4||data.length-index<tmp )return false;
                for (int i = index+1; i < index+tmp; i++) {
                        if (data[i]>>6!=2)return false;
                }
                index+=tmp;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidUtf8().validUtf8(new int[]{145}));
    }
}
