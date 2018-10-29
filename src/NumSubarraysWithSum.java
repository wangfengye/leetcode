/**

 * 在由若干 0 和 1  组成的数组 A 中，有多少个和为 S 的非空子数组。
 */
public class NumSubarraysWithSum {
    public int numSubarraysWithSum(int[] A, int S) {

        int result=0;
        for(int i=0;i<A.length;i++){
            int total=0;
            for(int j=i;j<A.length;j++){
                total+=A[j];
                if(total==S){//判断累加后的值是否为期待值，若是则子数组个数自增
                    ++result;
                }
                if(total>S){//大于期待值直接中断循环
                    break;
                }
            }
        }
        return result;
    }
}
