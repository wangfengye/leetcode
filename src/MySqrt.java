public class MySqrt {
    public static int mySqrt(int x) {
        if (x == 0) return 0;
        if (x < 4) return 1;
        int left = 0;
        int right = x / 2;
        while (right - left > 0) {
            int mid = (left + right) / 2;
            if (mid <= x / mid) {
                left = mid + 1;
            } else right = mid;
        }
        return left - 1;
    }

    /**
     * 牛顿逼近法
     * f(x) = x^2 - n
     * 求 f(x) = 0 的解
     * 取x0  做经过 (x0,f(x0))切线,交x轴于x1,重复操作 切线方程 f(x) =f(x0)+f'(xi)(x-xi);
     * 可得公式  x(i+1)= (x(i)+n/x(i))/2
     *
     * @param x 平方数
     * @return
     */
    public static int mySqrt1(int x) {
        if (x == 0) return 0;
        if (x < 4) return 1;
        int r = x / 2;
        while (r > x / r) {
            r = (r + x / r) / 2;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(MySqrt.mySqrt1(2147483647));
    }
}
