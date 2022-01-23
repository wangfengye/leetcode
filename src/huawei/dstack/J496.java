package huawei.dstack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * https://mp.weixin.qq.com/s/Y2QZZ-coEYZ6ItDRyrdwVw
 * 单调栈讲解: https://mp.weixin.qq.com/s/Y2QZZ-coEYZ6ItDRyrdwVw
 *
 * leetcode 最优,在使用单调栈,缓存结果的基础上, 把 stack,map使用数组取代.
 */
public class J496 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        // 使用单调栈求所有最近最大值
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length-1; i >=0; i--) {
            int tmp = nums2[i];
            while (!stack.isEmpty()&&stack.peek()<tmp){
                stack.pop();
            }
            map.put(tmp,stack.isEmpty()?-1:stack.peek());
            stack.push(tmp);

        }
        for (int i = 0; i < nums1.length; i++) {
            res[i]=map.get(nums1[i]);
        }
        return res;
    }
    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums1.length; i++) {
            int tmp = nums1[i];
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == tmp) {
                    for (j++; j < nums2.length; j++) {
                        if (nums2[j] > tmp) {
                            res[i] = nums2[j];
                            break;
                        }
                    }
                    break;
                }
            }

        }
        return res;
    }
}
