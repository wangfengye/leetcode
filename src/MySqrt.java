public class MySqrt {
    public static int mySqrt(int x) {
        if (x == 0) return 0;
        if (x < 4) return 1;
        int left = 0;
        int right = x/2 ;
        while (right - left > 0) {
            int mid = (left + right) / 2;
            if (mid <= x/mid) {
                left = mid+1;
            }

            else right = mid;
        }
        return left-1;
    }

    /**
     * 牛顿法开方 做切线,无线逼近; x^2 =m;
     * @param x
     * @return
     */
    public static int mySqrt1(int x) {
        if (x==0)return 0;
        if (x<4)return 1;
        int r = x/2;
        while (r>x/r){
            r=(r+x/r)/2;
        }
        return r;
    }
    public static void main(String[] args) {
        System.out.println(MySqrt.mySqrt1(2147483647));
    }
}
