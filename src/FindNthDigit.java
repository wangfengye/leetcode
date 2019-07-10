/**
 * @author maple on 2019/7/10 15:14.
 * @version v1.0
 * @see 1040441325@qq.com
 * 400. 第N个数字
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
 * <p>
 * 注意:
 * n 是正数且在32为整形范围内 ( n < 231)。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 3
 * <p>
 * 输出:
 * 3
 * 示例 2:
 * <p>
 * 输入:
 * 11
 * <p>
 * 输出:
 * 0
 * <p>
 * 说明:
 * 第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nth-digit
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindNthDigit {
    public static int findNthDigit(int n) {//暴力超时
        int i = 0;
        int len = 0;
        StringBuilder builder = new StringBuilder();
        while (true) {
            i++;
            builder.append(i);

            if (n - len <= builder.length()) {
                return builder.charAt(n - len - 1) - '0';
            }
            len += builder.length();
            builder.setLength(0);
        }
    }

    public static int findNthDigit2(int n) {
        long width =1;
        long base =9;
        long sum =0;
        while (n>base*width){
            n-=base*width;
            sum+=base;
            base*=10;
            width++;
        }
        if (width==1)return n;
        long num = sum+n/width;
        if (n%width==0)return (int) (num%10);
        else return  Integer.toString((int) (num+1)).charAt((int) (n%width-1))-'0';


    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(11));
        System.out.println(findNthDigit(1));
  ;
        System.out.println(findNthDigit(100));
        System.out.println(findNthDigit(999999999));
      //  System.out.println(findNthDigit(1000000000));
        System.out.println("******************** function2 *********************************");
        System.out.println(findNthDigit2(11));
        System.out.println(findNthDigit2(1));
        System.out.println(findNthDigit2(100));
        System.out.println(findNthDigit2(999999999));
       System.out.println(findNthDigit2(1000000000));
    }
}
