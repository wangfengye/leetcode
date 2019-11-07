/**
 * @author maple on 2019/11/7 10:00.
 * @version v1.0
 * @see 1040441325@qq.com
 * 299. 猜数字游戏
 * 你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。每次他猜测后，你给他一个提示，告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字。
 * <p>
 * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。
 * <p>
 * 请注意秘密数字和朋友的猜测数都可能含有重复数字。
 * 示例 1:
 * <p>
 * 输入: secret = "18071807", guess = "7810"
 * <p>
 * 输出: "1A3B"
 * <p>
 * 解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
 * 示例 2:
 * <p>
 * 输入: secret = "1123", guess = "0111"
 * <p>
 * 输出: "1A1B"
 * <p>
 * 解释: 朋友猜测数中的第一个 1 是公牛，第二个或第三个 1 可被视为奶牛.
 */
public class GetHint {
    public static String getHint(String secret, String guess) {
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        int A = 0, B = 0;
        int[] tmpS = new int[10];
        int[] tmpG = new int[10];
        for (int i = 0; i < s.length; i++) {
            if (s[i] == g[i]) {
                A++;
            }else {
                tmpS[s[i]-'0']++;
                tmpG[g[i]-'0']++;
            }
        }
        for (int i = 0; i < tmpG.length; i++) {
            B+=Math.min(tmpG[i],tmpS[i]);
        }
        return A + "A" + B + "B";
    }
    public static void main(String[] args){
        System.out.println(getHint("1807","7810"));
        System.out.println(getHint("1123","0111"));
    }
}