package javaBase;

import java.util.Arrays;

/**
 * @author maple on 2019/7/1 14:44.
 * @version v1.0
 * @see 1040441325@qq.com
 */
public class BastType {
    public static void main(String[] args) {
        byte a0 = 2, a1 = 4, a3;
        short b = 16;
        b = a1;//范围放大,无需显式转换类型
        b = 16;
        a1 = (byte) b;//值范围缩小,必须显式强转,
        a3 = (byte) (a0 * a1);
        testArrayCopy();
    }
    private static void testArrayCopy(){
        int[] a = new int[]{1,2,3};
        int[] b = new int[]{4,5,6};
        int[] c = new int[6];
        System.arraycopy(a,0,c,0,a.length);
        System.arraycopy(b,0,c,a.length,b.length);
        System.out.println(Arrays.toString(c));
    }
}
