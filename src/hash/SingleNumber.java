package hash;

/**
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int num = 0;
        for (int n : nums) {
            num ^= n;//按位异或操作, a^b^b = a;
        }
        return num;
    }
}
