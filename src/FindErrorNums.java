import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author maple on 2020/1/13 10:09.
 * @version v1.0
 * @see 1040441325@qq.com
 * 645. 错误的集合
 * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
 * <p>
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 */
public class FindErrorNums {
    public int[] findErrorNums(int[] nums) {
        boolean[] stand = new boolean[nums.length];
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (stand[nums[i]-1]) {
                res[0] = nums[i];
            }
            stand[nums[i]-1] = true;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!stand[i]) res[1] = i+1;
        }
        return res;
    }
}
