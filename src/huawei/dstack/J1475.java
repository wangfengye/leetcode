package huawei.dstack;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/final-prices-with-a-special-discount-in-a-shop/
 *
 * 裂开: 暴力算法,比单调栈还快
 */
public class J1475 {
    public static void main(String[] args){
        System.out.println(Arrays.toString(finalPrices(new int[]{8,4,6,2,3})));
        System.out.println(Arrays.toString(finalPrices2(new int[]{8,4,6,2,3})));
    }
    public static int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = prices.length-1; i >=0; i--) {
            int tmp = prices[i];
            while (!stack.isEmpty()&&stack.peek()>tmp){
                stack.pop();
            }
            res[i] = stack.isEmpty()?prices[i]:prices[i]-stack.peek();
            stack.push(tmp);
        }
        return  res;
    }
    public static int[] finalPrices2(int[] prices) {
        int[] res = new int[prices.length];
        System.arraycopy(prices,0,res,0,prices.length);
        for (int i =0;i <prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if(prices[i]>prices[j]){
                    res[i]=prices[i]-prices[j];
                    break;
                }
            }
        }
        return  res;
    }
}
