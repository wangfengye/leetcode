package interview;

import java.util.Set;
import java.util.Stack;

/**
 * @author maple on 2019/3/25 10:02.
 * @version v1.0
 * @see 1040441325@qq.com
 * 基本计算器 II
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * <p>
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分
 */
public class Calculate {
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int len = s.length();
        i = 0;
        while (i < len) {
            int tmp = s.charAt(i);
            switch (tmp) {
                case '+':
                    stack.push(getNum(s, i));
                    break;
                case '-':
                    stack.push(-getNum(s, i));
                    break;
                case '*':
                    int a = getNum(s, i);
                    stack.push(a * stack.pop());
                    break;
                case '/':
                    int b = getNum(s, i);
                    stack.push(stack.pop() / b);
                    break;
                case ' ':
                    i++;
                    break;
                default:
                    stack.add(getNum(s, i - 1));
                    break;
            }
        }
        int res = 0;
        while (!stack.empty()) {
            res += stack.pop();
        }
        return res;
    }

    static int i = 0;

    private static int getNum(String s, int i) {
        int res = 0;
        try {
            while (true) {
                i++;
                while (s.charAt(i)==' ')i++;
                res = res * 10 + Integer.valueOf(String.valueOf(s.charAt(i)));
                Calculate.i = i + 1;
            }
        } catch (Exception e) {
            return res;
        }
    }
    public static void main(String[] res){
        calculate(" 3/2 ");
    }
}
