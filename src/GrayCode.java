import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * <p>
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
 */
public class GrayCode {
    public static void main(String[] args) {
        //grayCode(2);
        grayCode2(2);
    }

    public static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        int len = 1 << n;
        for (int i = 0; i < len; i++) {
            /**
             * 根据格雷码公式生成格雷码,
             * 二进制自然码 指从0开始的连续整数
             * 将二进制码的每一位与高一位取异或,最高位不变,可得格雷码
             */
            list.add(i ^ (i >> 1));
        }
        return list;
    }

    /**
     * 递归生成法
     * 本体,前缀+0;
     * 镜像,前缀+1;
     * @param n
     * @return
     */
    public static List<Integer> grayCode2(int n) {
        return grayCode2Get(n);
    }
    private static List<Integer> grayCode2Get(int n){
        if (n==0){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(0);
            return list;
        }
        if (n==1){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(1);
            return list;
        }
        ArrayList<Integer> list = (ArrayList<Integer>) grayCode2Get(n-1);
        int len =list.size();
        for (int i = len-1; i >=0 ; i--) {
            int a=list.get(i)+(1<<(n-1));
            list.add(a);
        }
        return list;
    }

}
