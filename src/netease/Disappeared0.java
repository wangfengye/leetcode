package netease;

/**
 * @author maple on 2019/6/21 16:10.
 * @version v1.0
 * @see 1040441325@qq.com
 * 消失的0, 长度为n的数组 包含0-n,的连续数,缺失一个值,找出
 *
 */
public class Disappeared0 {
    private static int find(int[] nums){
      int l = 0;int r=nums.length-1;
      while (l<=r){
          int mid =(l+r)/2;
          if (nums[mid]==mid){
              l=mid+1;
          }else {
              r=mid-1;
          }
      }
      return l;
    }
    // 进阶,非连续
    private static int findSuper(int[] nums){
        int sumBase=nums.length;
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            sumBase+=i;
        }
        return sumBase-sum;
    }
    public static void main(String[] args){
        System.out.println(find(new int[]{0,1,2,3,4,6}));
        System.out.println(findSuper(new int[]{0,1,2,3,4,6}));
        System.out.println(find(new int[]{0,1,2,3,4,5}));
        System.out.println(findSuper(new int[]{0,1,2,3,4,5}));
        System.out.println(find(new int[]{1,2,3,4,5,6}));
        System.out.println(findSuper(new int[]{1,2,3,4,5,6}));
        System.out.println(find(new int[]{0,1,2,4,5,6}));
        System.out.println(findSuper(new int[]{0,1,2,4,5,6}));
    }
}
