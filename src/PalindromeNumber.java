/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if(x<0)return false;
        String a = String.valueOf(x);
        String b = new StringBuffer(a).reverse().toString();
        return (a).equals(b);
    }
    public static boolean isPalindrome2(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int halfReverseX = 0;
        //后一半取反,奇数量多取一位
        while (x > halfReverseX) {
            halfReverseX = halfReverseX * 10 + x % 10;
            x /= 10;
        }
        //取的数==剩余数/取的数少一位==剩余数.
        return halfReverseX == x || halfReverseX / 10 == x;
    }
    public static void main(String[] args){
        System.out.println(  isPalindrome(10));
        System.out.println(isPalindrome2(1221));
        System.out.println(isPalindrome2(1423));
    }
}
