/**
 * @author maple on 2019/6/4 10:36.
 * @version v1.0
 * @see 1040441325@qq.com
 * 如 0, 1, 6, 8, 9 旋转 180° 以后，得到了新的数字 0, 1, 9, 8, 6 。
 * <p>
 * 2, 3, 4, 5, 7 旋转 180° 后,得到的不是数字。
 * <p>
 * 易混淆数字 (confusing number) 就是一个数字旋转180°以后，得到和原来不同的数字，且新数字的每一位都是有效的。
 */
public class ConfusingNumber {
    private static final int[] DIFF = new int[]{6, 9};
    private static final int[] SAME = new int[]{0, 1, 8};

    public boolean confusingNumber(int N) {
        int tmp = N;
        int after = 0;
        while (tmp > 0) {
            if (tmp % 10 == 6) {
                after = after * 10 + 9;
            } else if (tmp % 10 == 9) {
                after = after * 10 + 6;
            } else if (contains(SAME, tmp % 10)) {
                after = after * 10 + tmp % 10;
            } else {
                return false;
            }
            tmp /= 10;
        }
        return after != N;
    }

    private static boolean contains(int[] s, int t) {
        for (int s1 : s) {
            if (s1 == t) return true;
        }
        return false;
    }
    public static void main(String[] at){
        new ConfusingNumber().confusingNumber(6);
    }
}
