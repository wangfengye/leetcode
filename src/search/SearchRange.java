package search;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        boolean find =false;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target){l=m;find =true;break;}
            if (target < nums[m]) r = m -1;
            else l = m+1;
        }
        if (!find)return new int[]{-1,-1};
        r=l;
        while (l>0){if (nums[l-1]==target)l--;else break;}
        while (r<nums.length-1){if (nums[r+1]==target)r++;else break;}
        return new int[]{l,r};
    }

    /**
     * 分解成两个二分法分别求最左侧,和最右侧
     */
    public int[] searchRange2(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        if (nums.length==0)return res;
        res[0] = targetLeft(nums,target);
        res[1] = targetRight(nums,target,res[0]);
        return res;
    }
    private int targetLeft(int[] nums, int target){
        int l =0;
        int r = nums.length-1;
        while (l<=r){
            int mid = (r-l)/2+l;
            if (nums[mid]<target)l=mid+1;
            else r=mid-1;
        }
        if (l<nums.length&&nums[l]==target)return l;
        return -1;
    }
    private int targetRight(int[] nums, int target,int l) {
        if (l < 0) return -1;//targetLeft 为-1,表示数组中无目标元素
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] == target) l = mid + 1;
            else r = mid - 1;
        }
        if (l < nums.length && nums[l] == target) return l;
        return l - 1;
    }
        public static void main(String[] args){
       // System.out.println(new SearchRange().targetLeft(new int[]{5,7,7,8,8,10},8));
        System.out.println(new SearchRange().targetRight(new int[]{5,7,7,8,8,10},8,3));
    }
}
