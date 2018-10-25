package QueueAndStack;

/**
 * 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少
 */
public class NumSquares {
    /**
     * 四平方定理(任意一个正整数均可表示为4个整数的平方和)
     * 1.数值简化,一直除4直至武汉因数4
     * 2. 若 n%8==7 则为4个平方数的和
     * 3. 尝试以两个数拼接 若成功且不包括0,则为两个数的平方和,含有0,为一个数的平方数
     * 4. 剩余则是三个平方数的和
     * @param n
     * @return
     */
    public int numSquares(int n) {
        while (n%4 ==0)n/=4;
        if (n%8==7)return 4;
        for (int i = 0; i*i<=n; i++) {
            int b = (int) Math.sqrt(n-i*i);
            if (b*b+i*i == n){
                if (i==0||b==0)return 1;
                else return 2;
            }
        }
        return 3;
    }
}
