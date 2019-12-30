import java.util.Arrays;

/**
 * @author maple on 2019/12/22 16:22.
 * @version v1.0
 * @see 1040441325@qq.com
 * 541. 反转字符串 II
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
 * 示例:
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 */
public class ReverseStr {
    public String reverseStr(String s, int k) {
        char[] cs=s.toCharArray();
        int i=0;
        while (i<s.length()){
            int l= i;
            int r= i+k-1;
            if (r>=s.length())r=s.length()-1;
            while (l<r){
                char tmp= cs[l];
                cs[l]=cs[r];
                cs[r]=tmp;
                l++;r--;
            }
            i+=2*k;
        }
        return new String(cs);
    }
    public static void main(String[] args){
        System.out.println(new ReverseStr().reverseStr("abcdefg",2));
    }
}
