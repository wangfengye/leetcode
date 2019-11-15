package Array;

/**
 * @author maple on 2019/11/13 10:58.
 * @version v1.0
 * @see 1040441325@qq.com
 * 81. 搜索旋转排序数组 II
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * <p>
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 */
public class Search {

    public boolean search(int[] nums, int target) {
        return search2(nums, target, nums.length);
    }

    /**
     * 相對於問題1引入了重複元素的問題.當首尾元素相等時無法判斷是否有序,
     * 處理方式:当首尾相同时,去掉尾部元素.
     */
    public boolean search2(int[] nums, int target, int len) {
        if (len == 0) return false;
        if (len==1){
            if (nums[0]==target){
                return true;
            }else {
                return false;
            }
        }
        if (nums[0] == nums[len - 1]) {
            return search2(nums, target, len - 1);
        }
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return true;
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
        return false;
    }
    public static void main(String[] args){
        System.out.println(new Search().search(new int[]{2,5,6,0,0,1,2},0));
        System.out.println(new Search().search(new int[]{2,5,6,0,0,1,2},3));
        System.out.println(new Search().search(new int[]{1,3,1,1,1},3));
    }
}