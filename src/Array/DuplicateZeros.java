package Array;

import java.util.Arrays;

/**
 * 1089. 复写零
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * <p>
 * 注意：请不要在超过该数组长度的位置写入元素。
 * <p>
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * 示例 2：
 * <p>
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 */
public class DuplicateZeros {
    public static void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {//最后一位无需复制
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j > i + 1; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[i + 1] = 0;
                i++;
            }
        }
    }

    public static void fun2(int[] arr) {
        int n = arr.length;
        int i = 0, j = 0;
        //首次遍历,判断有几个0可扩容.

        while (j < n) {
            if (arr[i] == 0) j++;
            i++;
            j++;
        }
        //回到最后一个合法位置
        i--; //i为扩容最后一个字符位置
        j--;//n-1;当最后一个字符为0时是n;
        // 从末尾修改数组,
        while (i >= 0) {
            if (j < n) arr[j] = arr[i];
            if (arr[i] == 0) arr[--j] = 0;//向前扩展一个0
            i--;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        int[] test2 = new int[]{1, 2, 3};
        int[] test3 = new int[]{0, 0, 0, 0, 0, 0, 0};
        DuplicateZeros.duplicateZeros(test1);
        System.out.println(Arrays.toString(test1));
        DuplicateZeros.duplicateZeros(test2);
        System.out.println(Arrays.toString(test2));
        DuplicateZeros.duplicateZeros(test3);
        System.out.println(Arrays.toString(test3));
    }
}
