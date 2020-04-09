import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 */
public class GenerateParenthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> res =new ArrayList<>();
        bfs(n,n,new StringBuilder(),2*n,res);
        return res;
    }

    /**
     *
     * @param l 剩余左括号
     * @param r 剩余右括号
     * @param builder
     * @param len
     * @param res
     */
    private static void bfs(int l,int r,StringBuilder builder,int len,List<String> res){
        if(builder.length()==len){
            res.add(builder.toString());
            return;
        }
        if(l<r){
            int tmplen=builder.length();
            builder.append(')');
            bfs(l,r-1,builder,len,res);
            builder.setLength(tmplen);
        }
        if(l>0){
            int tmplen=builder.length();
            builder.append('(');
            bfs(l-1,r,builder,len,res);
            builder.setLength(tmplen);
        }
    }
    public static void main(String[] args){
        List<String> res = generateParenthesis(3);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
