package search;

/**
 * @author maple on 2018/11/27 9:21.
 * @version v1.0
 * @see 1040441325@qq.com
 * <p>
 * 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设只有一个重复的整数，找出这个重复的数。
 */
public class FindDuplicate {
    /**
     * 长度为n+1的数组,包含1`n的元素,必然有一个重复数,
     * 类比成一个链表,则是求一个有环的链表的环入口;
     */
    public static int findDuplicate(int[] nums) {
        int slow = 0, fast = 0, t = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        do {
            slow = nums[slow];
            t = nums[t];
        } while (slow != t);
        return slow;
    }
    public static void main(String[] args){
        findDuplicate(new int[]{3,1,3,4,2});
    }
}
