import java.util.Arrays;
import java.util.HashMap;

/**
 * 1111. 有效括号的嵌套深度
 * 有效括号字符串 仅由 "(" 和 ")" 构成，并符合下述几个条件之一：
 *
 * 空字符串
 * 连接，可以记作 AB（A 与 B 连接），其中 A 和 B 都是有效括号字符串
 * 嵌套，可以记作 (A)，其中 A 是有效括号字符串
 * 类似地，我们可以定义任意有效括号字符串 s 的 嵌套深度 depth(S)：
 *
 * s 为空时，depth("") = 0
 * s 为 A 与 B 连接时，depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是有效括号字符串
 * s 为嵌套情况，depth("(" + A + ")") = 1 + depth(A)，其中 A 是有效括号字符串
 * 例如：""，"()()"，和 "()(()())" 都是有效括号字符串，嵌套深度分别为 0，1，2，而 ")(" 和 "(()" 都不是有效括号字符串。
 *
 *
 *
 * 给你一个有效括号字符串 seq，将其分成两个不相交的子序列 A 和 B，且 A 和 B 满足有效括号字符串的定义（注意：A.length + B.length = seq.length）。
 *
 * 现在，你需要从中选出 任意 一组有效括号字符串 A 和 B，使 max(depth(A), depth(B)) 的可能取值最小。
 *
 * 返回长度为 seq.length 答案数组 answer ，选择 A 还是 B 的编码规则是：如果 seq[i] 是 A 的一部分，那么 answer[i] = 0。否则，answer[i] = 1。即便有多个满足要求的答案存在，你也只需返回 一个。
 *
 *
 *
 * 示例 1：
 *
 * 输入：seq = "(()())"
 * 输出：[0,1,1,1,1,0]
 * 示例 2：
 *
 * 输入：seq = "()(())()"
 * 输出：[0,0,0,1,1,0,1,1]
 */
public class MaxDepthAfterSplit {
    /**
     *
     *          (()())
     * 计算深度   011110
     *
     * 按深度的奇偶性,分配字符
     *
     * @param seq
     * @return
     */
    public static int[] maxDepthAfterSplit(String seq) {
        int[] res=new int[seq.length()];
        int i=0;
        int d =0;//表示深度
        for(char c:seq.toCharArray()){
            if(c=='('){//遇'(',深度增加
                d++;
                res[i]=d%2;
            }else {//深度减小.
                res[i]=d%2;
                d--;
            }
            i++;
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(Arrays.toString(maxDepthAfterSplit("(()())")));
        System.out.println(Arrays.toString(maxDepthAfterSplit("()(())()")));
    }
}
