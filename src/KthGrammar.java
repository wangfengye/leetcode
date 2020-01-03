/**
 * @author maple on 2020/1/3 10:55.
 * @version v1.0
 * @see 1040441325@qq.com
 * 第K个语法符号
 */
public class KthGrammar {
    public static int kthGrammar(int N, int K) {
        if (N == 1) return 0;
        //kthGrammar(N-1, (K+1)/2)对应上个字符串的位置.
        // k last 结果
        // 1  1   0
        // 0  1   1
        // 1  0   1
        // 0  0   0
        // 使用异或符
        //~ 按位取反
       // return (~K & 1) ^ kthGrammar(N-1, (K+1)/2);
       return (K-1)&1 ^ kthGrammar(N-1, (K+1)/2);
    }

    public static void main(String[] args){
        System.out.println( KthGrammar.kthGrammar(30,434994989));
    }
}
