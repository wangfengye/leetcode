package search;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class MyPow {
    public double myPow(double x, int n) {
        if (n < 0) return 1 / power(x, -n);
        return power(x, n);
    }
    private double power(double x, int n) {
        if (n == 0) return 1;
        double half = power(x, n / 2);
        if (n % 2 == 0) return half * half;
        return x * half * half;
    }
    public static void main(String[] args){
        System.out.println(new MyPow().myPow(8.84372,5));
    }
}
