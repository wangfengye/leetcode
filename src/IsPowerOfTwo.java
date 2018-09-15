/**
 *   2的幂
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方
 */
public class IsPowerOfTwo {
    /**
     * 按位与,判断出首位外,还有没有位数职位1;
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n<1)return false;
        while (n>1){
            if((n&1)==1)return false;
            n=n>>1;
        }
        return true;
    }

    /**
     *  符合要求的数二进制位  1000...
     *    n-1 de二进制        0111...
     * @param n
     * @return
     */
    public boolean isPowerOfTwo2(int n) {
        return (n>0 && (n&(n-1))==0);
    }

}
