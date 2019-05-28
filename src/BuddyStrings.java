import java.util.HashSet;

/**
 * @author maple on 2019/5/28 10:57.
 * @version v1.0
 * @see 1040441325@qq.com
 * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入： A = "ab", B = "ba"
 * 输出： true
 * 示例 2：
 *
 * 输入： A = "ab", B = "ab"
 * 输出： false
 * 示例 3:
 *
 * 输入： A = "aa", B = "aa"
 * 输出： true
 * 示例 4：
 *
 * 输入： A = "aaaaaaabc", B = "aaaaaaacb"
 * 输出： true
 * 示例 5：
 *
 * 输入： A = "", B = "aa"
 * 输出： false
 */
public class BuddyStrings {
    public static boolean buddyStrings(String A, String B) {
        if (A.length()!=B.length())return false;
        char[] a = new char[2];
        char[] b = new char[2];
        int diffLen = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i)!=B.charAt(i)){
                if (diffLen>=2)return false;
                a[diffLen] =A.charAt(i);
                b[diffLen] =B.charAt(i);
                diffLen++;
            }
        }

        if(diffLen==0){//A,B完全相同,找出可交换的重复元素
            HashSet<Character> set = new HashSet<>();
            for (Character c : A.toCharArray()) {
               if (!set.add(c))return true;
            }
            return false;
        }
        if (a[0]==b[1]&a[1]==b[0])return true;
        else return false;
    }
    public static void main(String[] args){
        System.out.println(buddyStrings("ab","ab"));
        System.out.println(buddyStrings("aa","aa"));
    }
}
