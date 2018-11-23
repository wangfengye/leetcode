package search;

/**
 * @author maple on 2018/11/23.
 * @version v1.0
 * @see 1040441325@qq.com\
 * desc  有效的完全平方数
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 */
public class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num == 0||num==1||num==4) return true;
        if (num < 4) return false;
        int r = num / 2;
        while (r > num / r) {
            r = (r + num / r) / 2;
        }
        return r*r==num;
    }
}
