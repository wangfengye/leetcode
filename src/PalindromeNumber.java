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
    public static void main(String[] args){
        isPalindrome(10);
    }
}
