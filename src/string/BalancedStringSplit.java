package string;

/**
 * 1221. 分割平衡字符串
 * 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
 *
 * 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 *
 * 返回可以通过分割得到的平衡字符串的最大数量。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "RLRRLLRLRL"
 * 输出：4
 * 解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
 * 示例 2：
 *
 * 输入：s = "RLLLLRRRLR"
 * 输出：3
 * 解释：s 可以分割为 "RL", "LLLRRR", "LR", 每个子字符串中都包含相同数量的 'L' 和 'R'。
 * 示例 3：
 *
 * 输入：s = "LLLLRRRR"
 * 输出：1
 * 解释：s 只能保持原样 "LLLLRRRR".
 */
public class BalancedStringSplit {
    public static int balancedStringSplit(String s) {
        int count=0;
        int L=0;
        int R=0;
        for(char c:s.toCharArray()){
            if(c=='L'){
                L++;
            }else {
                R++;
            }
            if(L>0&&L==R){
                L=0;R=0;
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
        System.out.println(balancedStringSplit("RLLLLRRRLR"));
        System.out.println(balancedStringSplit("LLLLRRRR"));
    }
}
