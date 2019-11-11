/**
 * @author maple on 2019/11/8 10:19.
 * @version v1.0
 * @see 1040441325@qq.com
 * 65. 有效数字
 * 验证给定的字符串是否可以解释为十进制数字。
 * <p>
 * 例如:
 * <p>
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 * <p>
 * 说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表：
 * <p>
 * 数字 0-9
 * 指数 - "e"
 * 正/负号 - "+"/"-"
 * 小数点 - "."
 * 当然，在输入中，这些字符的上下文也很重要。
 * <p>
 * 更新于 2015-02-10:
 */
public class IsNumber {
    public static boolean isNumber(String s) {
        s=s.trim();
        if (s.length()<=0)return false;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1);
        }
        int i = 0;

        boolean hasPoint = false;
        boolean hasE = false;
        boolean hasNum = false;
        if (s.length()<=0)return false;
        while (i < s.length()) {
            if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
                i++;
                hasNum=true;
            } else if (s.charAt(i) == 'e') {
                if (hasE){return false;}
                    hasE=true;
                if (i + 1 == s.length()) return false;
                if (i == 0) return false;
              if (!hasNum)return false;
                if (s.charAt(i+1)=='+'||s.charAt(i+1)=='-'){
                    if(i+2>=s.length())return false;
                    if (s.charAt(i+2) - '0' <0 || s.charAt(i+2) - '0' >9)return false;
                    i+=3;
                    continue;
                }
                if(s.charAt(i+1) - '0' <0 || s.charAt(i+1) - '0' >9)return false;
                i+=2;
            } else if (s.charAt(i) == '.') {
                if (hasE)return false;
                if (!hasPoint && ((i<s.length()-1)||i>0)) {
                    hasPoint = true;i++;
                }else {
                    return false;
                }

            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNumber("1"));
        System.out.println(isNumber("1.1"));
        System.out.println(isNumber("1.1.1"));
        System.out.println(isNumber("."));
        System.out.println(isNumber(".e1"));
        System.out.println(isNumber("2e0"));
        System.out.println(isNumber("1e6"));
        System.out.println(isNumber(" "));
        System.out.println(isNumber(" .e1"));
        System.out.println(isNumber(" 46.e1"));
        System.out.println(isNumber(" 99e2.5"));
    }
}
