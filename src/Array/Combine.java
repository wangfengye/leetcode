package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maple on 2019/11/13 9:30.
 * @version v1.0
 * @see 1040441325@qq.com
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Combine {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        combineDispatch(res, tmp, 1, n, k);
        return res;
    }

    private static void combineDispatch(List<List<Integer>> res,List<Integer> tmp, int i, int n, int k) {
        if (tmp.size() == k) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int j = i; j <= n; j++) {
            tmp.add(j);
            combineDispatch(res,tmp,j+1,n,k);
            tmp.remove(tmp.size()-1);
        }
    }
    public static void main(String[] args){
        List<List<Integer>> data = combine(4, 2);
        for(List<Integer> a:data){
            for(Integer b:a){
                System.out.print(b);
            }
            System.out.println();
        }
    }
}
