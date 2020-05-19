/**
 * 翻转数组
 * Example 123->321;
 * 思路,for循环加,注意超限情况
 */
public class ReverseInteger {
    public static int reverse(int i) {
        boolean flag = i < 0;
        if (flag) i = -i;
        long res = 0;
        while (i > 0) {
            res *= 10;
            int tmp = i % 10;
            res += tmp;
            i /= 10;
        }
        if (!flag && res > Integer.MAX_VALUE || flag && -res < Integer.MIN_VALUE) {
            throw new RuntimeException("out of Integer memory");
        }
        return (int) (flag ? -res : res);
    }
    public static int reverse1(int x) {
        long res = 0;
        for (; x != 0; x /= 10)
            res = res * 10 + x % 10;
        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0 : (int) res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(-103));
        System.out.println(reverse(-13));
        System.out.println(reverse(Integer.MAX_VALUE));
        System.out.println("\n************************************\n");

        System.out.println(reverse1(123));
        System.out.println(reverse1(-123));
        System.out.println(reverse1(-103));
        System.out.println(reverse1(-13));
        System.out.println(reverse1(Integer.MAX_VALUE));
    }
}
