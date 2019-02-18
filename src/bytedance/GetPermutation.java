package bytedance;

import java.util.ArrayList;

/**
 * @author maple on 2019/2/18 17:09.
 * @version v1.0
 * @see 1040441325@qq.com
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 */
public class GetPermutation {
    public String getPermutation(int n, int k) {
        StringBuilder builder = new StringBuilder();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            nums.add(i);
        }
        int count = get(n);
        for (int i = 0; i <n; i++) {
             count = count/(n-i);
            int temp = (k-1) / count;
            k=k-count*temp;
            builder.append(nums.get(temp));
            nums.remove(temp);

        }
        return builder.toString();
    }
    private int get(int i){
        if (i==0)return 1;
        if (i==1)return 1;
        else return get(i-1)*i;
    }
    public static void main(String[] args){
       System.out.println( new GetPermutation().getPermutation(3,6));
    }
}
