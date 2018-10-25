package QueueAndStack;

import java.util.Stack;

/**
 * 根据逆波兰表示法，求表达式的值
 */
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")){
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left+right);
            }else if ("-".equals(tokens[i])){
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left-right);
            }else if ("*".equals(tokens[i])){
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left*right);
            }else if ("/".equals(tokens[i])){
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left/right);
            }else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
    public static void main(String[] args){
        System.out.println(new EvalRPN().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(new EvalRPN().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
