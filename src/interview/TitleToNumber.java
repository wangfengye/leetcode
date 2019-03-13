package interview;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @author maple on 2019/3/11 14:50.
 * @version v1.0
 * @see 1040441325@qq.com
 * Excel表列序号
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * <p>
 * 例如，
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * 示例 1:
 * <p>
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 * <p>
 * 输入: "ZY"
 * 输出: 701
 */
public class TitleToNumber {
    public int titleToNumber(String s) {
        int res = 0;
        int multiple = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            res += (s.charAt(i) - '@') * multiple;
            multiple *= 26;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println((char) 64);
        // 证明 trimToSize()后 elementData数组长度变为实际存储内容的数组长度;
        ArrayList<Integer> s = new ArrayList<>();
        s.add(1);
        showElementDataLength(s);
        s.trimToSize();
        showElementDataLength(s);
        // subString 在1.7之后进行了重构,不再复用value数组
        String a = "ABCDEFGH";
        String b = a.substring(0,3);

        showEle(a);
        System.out.println("a: " +a);
        System.out.println("b: " +b);
        showEle(b);
    }

    private static void showEle(String s) {
        Field field = null;
        try {
            field = s.getClass().getDeclaredField("value");
            field.setAccessible(true);
            char[] el = (char[]) field.get(s);
            el[0] ='@';
            System.out.println(el.length);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void showElementDataLength(ArrayList<Integer> s){
        Field field = null;
        try {
            field = s.getClass().getDeclaredField("elementData");
            field.setAccessible(true);
            Object[] el = (Object[]) field.get(s);
            System.out.println(el.length);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
