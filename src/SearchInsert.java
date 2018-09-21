/**
 * 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素
 */
public class SearchInsert {
    /**
     * 二分法
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] >= target) return left;
        else return left + 1;
    }
    public static int searchInsert1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target<=nums[i])return i;
        }
        return nums.length;
    }
    public static void main(String[] args){
        System.out.println("开始1");
        long time = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            SearchInsert.searchInsert(new int[]{1,3,5,6},5);
            SearchInsert.searchInsert(new int[]{1,3,5,6},2);
            SearchInsert.searchInsert(new int[]{1,3,5,6},7);
            SearchInsert.searchInsert(new int[]{1,3,5,6},0);
        }
        System.out.println(System.currentTimeMillis()-time);
        System.out.println("开始2");
        time = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            SearchInsert.searchInsert1(new int[]{1,3,5,6},5);
            SearchInsert.searchInsert1(new int[]{1,3,5,6},2);
            SearchInsert.searchInsert1(new int[]{1,3,5,6},7);
            SearchInsert.searchInsert1(new int[]{1,3,5,6},0);
        }
        System.out.println(System.currentTimeMillis()-time);
    }
}
