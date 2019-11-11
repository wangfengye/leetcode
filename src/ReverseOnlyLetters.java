import java.util.Arrays;

/**
 * @author maple on 2019/11/7 15:04.
 * @version v1.0
 * @see 1040441325@qq.com
 * 917. 仅仅反转字母
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 *
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 *
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 *  
 *
 * 提示：
 *
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122 
 * S 中不包含 \ or "
 */
public class ReverseOnlyLetters {
    private static boolean isWord(char c){
      return (c>='a'&&c<='z')||(c>='A'&&c<='Z');
    }
    public static String reverseOnlyLetters(String s){
        char[] cs = s.toCharArray();
        int l=0,r=cs.length-1;
        while (l<r){
            if (isWord(cs[l]) &&isWord(cs[r])){
                char tmp= cs[l];
                cs[l]=cs[r];
                cs[r]=tmp;
                l++;r--;
            }else{
                if (!isWord(cs[l])){
                    l++;
                }
                if (!isWord(cs[r])){
                    r--;
                }
            }
        }
        return String.valueOf(cs);
    }
    public static void main(String[] args){
        System.out.println(reverseOnlyLetters("ab-cd"));
        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
