/**
 * @author maple on 2019/6/28 9:40.
 * @version v1.0
 * @see 1040441325@qq.com
 * 44. 通配符匹配
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 *
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 *
 */
public class IsMatch2 {
    public boolean isMatch(String s, String p) {
       int a =0;
       int b =0;
       int start =-1;
       int match =0;
        while (a<s.length()){
            if (b<p.length()&&(s.charAt(a)==p.charAt(b)||p.charAt(b)=='?')){
                a++;b++;
            }else if (b<p.length()&&p.charAt(b)=='*'){
                start =b;//记录*位置
                match =a;
                b++;
            }else if (start!=-1){//适配*后
                b=start+1;
                match++;
                a=match;
            }else {
                return false;
            }
        }
        while (b<p.length()){
            if (p.charAt(b)!='*')return false;b++;
        }
        return true;
    }
}
