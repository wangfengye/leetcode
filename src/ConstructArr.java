/**
 * 面试题66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 */
public class ConstructArr {
    public int[] constructArr(int[] a) {
        int[] b=new int[a.length];
        if(b.length==0)return b;
        b[0]=1;
        // 先把左侧的积算出来
        for (int i = 1; i < a.length; i++) {
            b[i]=b[i-1]*a[i-1];
        }
        int r=1;//记录i 右侧的积.
        for (int i =a.length-1; i >=0;i--) {
            b[i]*=r;
            r*=a[i];
        }
        return b;
    }
}
