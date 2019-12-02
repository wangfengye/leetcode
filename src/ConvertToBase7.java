/**
 * @author maple on 2019/11/30 11:48.
 * @version v1.0
 * @see 1040441325@qq.com
 * 504. 七进制数
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 *
 * 示例 1:
 *
 * 输入: 100
 * 输出: "202"
 * 示例 2:
 *
 * 输入: -7
 * 输出: "-10"
 * 注意: 输入范围是 [-1e7, 1e7] 。
 */
public class ConvertToBase7 {
    public static String convertToBase7(int num) {
        if (num==0)return "0";
        StringBuilder builder=new StringBuilder();
        boolean a=false;
        if (num<0){
            num=-num;
            a=true;
        }
        while (num>0){
            int tmp= num%7;
            num=num/7;
            builder.insert(0,tmp);
        }
        if (a)builder.insert(0,'-');
        return builder.toString();
    }
    public static void main(String[] args){
        System.out.println(convertToBase7(100));
        System.out.println(convertToBase7(-7));
    }
}
