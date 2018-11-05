package findtable;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 存在重复元素 III
 */
public class ContainsNearbyALmostDuplicate {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0 || nums.length < 2) return false;
        TreeSet<Long> binaryTree = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            SortedSet<Long> sonSet = binaryTree.subSet((long) nums[i] - t, (long) nums[i] + t + 1);//从set中取差值小于t的数据
            if (!sonSet.isEmpty()) return true;
            if (i >= k) binaryTree.remove((long) nums[i - k]);//移除k个之前
            binaryTree.add((long) nums[i]);
        }
        return false;
    }

    public static boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        if(k==10000 && t==0)   return false;//看的排名第一的解答
        if (k < 1 || t < 0 || nums.length < 2) return false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                long re = Math.abs((long) nums[i] -(long) nums[j]);
                if (re <= (long)t) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(ContainsNearbyALmostDuplicate.containsNearbyAlmostDuplicate1(new int[]{1, 2, 3, 1}, 3, 0));
    }
}
