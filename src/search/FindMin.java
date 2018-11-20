package search;

/**
 * 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 */
public class FindMin {
    public int findMin(int[] nums) {
        int l =0;
        int r =nums.length-1;
        while (l<r){
            int mid = (r-l)/2+l;
            //未旋转的部分符合  nums[l]<nums[mid]<nums[r] =表示 mid == l/r  取左侧点
            if (nums[mid]>=nums[l]&&nums[mid]<=nums[r])return nums[l];
            if (nums[mid]<nums[l])r =mid;
            else l =mid+1;
        }
        return nums[l];
    }
public static void main(String[] args){
        System.out.println(new FindMin().findMin(new int[]{3,4,5,1,2}));
        System.out.println(new FindMin().findMin(new int[]{4,5,6,7,0,1,2}));
}
    }
