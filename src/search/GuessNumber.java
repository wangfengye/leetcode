package search;

/**
 * 猜数字大小
 * <p>
 * 们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）
 */
public class GuessNumber extends GuessGame {
    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        while (l <= r) {
            int m = (r - l) / 2 + l;//先减后加,防止超出int最大值;
            int diff = guess(m);
            if (diff == 0) return m;
            if (diff == -1) r = m - 1;
            else l = m + 1;
        }
        return -1;
    }
}

class GuessGame {
    int pick = 6;

    public int guess(int n) {
        if (pick > n) return -1;
        if (pick == n) return 0;
        else return 1;
    }
}
