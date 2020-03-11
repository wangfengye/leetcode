/**
 * 1013. 将数组分成和相等的三个部分
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 * <p>
 * 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输出：[0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * 示例 2：
 * <p>
 * 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：[3,3,6,5,-2,2,5,1,-9,4]
 * 输出：true
 * 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 */
public class CanThreePartsEqualSum {
    public static boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        if(sum%3!=0)return false;
        sum=sum/3;
        int s = 0;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            s += A[i];
            if (s == sum) {
                if (count == 0) {
                    count++;
                    s=0;
                } else {
                    if (i < A.length - 1) return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(CanThreePartsEqualSum.canThreePartsEqualSum(new int[]{0,2,1,-6,6,-7,9,1,2,0,1}));
        System.out.println(CanThreePartsEqualSum.canThreePartsEqualSum(new int[]{0,2,1,-6,6,7,9,-1,2,0,1}));
        System.out.println(CanThreePartsEqualSum.canThreePartsEqualSum(new int[]{3,3,6,5,-2,2,5,1,-9,4}));
    }
}
