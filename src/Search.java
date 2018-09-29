/**
 * 搜索旋转排序数组
 */
public class Search {
    /**
     * 二分法
     *345612大家都在发
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] >= nums[left]) {//左侧有序
                if (nums[mid] > target && nums[left] <= target) {//target中间
                    right = mid - 1;
                } else {//不在左侧,
                    left = mid + 1;
                }
            } else {//右侧有序
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
    public int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > nums[right]) {
                if (nums[mid] < target || target<= nums[right]) {
                    left = mid +1;
                } else {//不在左侧,
                    right = mid-1;
                }
            } else {//右侧有序
                if (nums[mid]<target && target<= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
