package Array;

/**
 * 至少是其他数字两倍的最大数
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍
 */
public class DominantIndex {
    public int dominantIndex(int[] nums) {
        int sec= 0;
        int max =0;
        int index =-1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>max){
                sec = max;
                max=nums[i];
                index =i;
            }else if (nums[i]>sec){
                sec =nums[i];
            }
        }
        if (max>=2*sec)return index;
        else return -1;
    }
    public static void main(String[] args){
        System.out.println(new DominantIndex().dominantIndex(new int[]{3, 6, 1, 0}));
    }
}
