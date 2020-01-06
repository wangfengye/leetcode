package Array;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author maple on 2020/1/6 9:43.
 * @version v1.0
 * @see 1040441325@qq.com
 * 581. 最短无序连续子数组
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 你找到的子数组应是最短的，请输出它的长度。
 *
 * 示例 1:
 *
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 */
public class FindUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int[] copy= Arrays.copyOf(nums,nums.length);
        Arrays.sort(copy);
        int left=0;
        int right=-1;
        for (int i = 0; i < nums.length; i++) {
            if(copy[i]!=nums[i]){
                left=i;break;
            }
        }
        for (int i =  nums.length-1; i >=0; i--) {
            if(copy[i]!=nums[i]){
                right=i;break;
            }
        }
        return right-left+1;
    }
    public int findUnsortedSubarray2(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int l = nums.length;
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            //遇到降序,移除压栈的数据,
            //遍历完成后可找到降序的最左侧元素
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                l = Math.min(l, stack.pop());
            }
            //升序压栈
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length-1; i >= 0; i--) {
            //遇到降序,移除压栈的数据,
            //遍历完成后可找到降序的最左侧元素
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                r = Math.max(r, stack.pop());
            }
            //升序压栈
            stack.push(i);
        }
        stack.clear();
        return r-l>0?r-l+1:0;
    }
}
