/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成
 */
public class RemoveDuplicates {
    /**
     * 分析: len 删除后的长度 counter相同元素数量
     *  1.下一个是不同元素, 记录元素,重置counter,
     *  2.第一次遇到相同元素,记录元素,counter +1;
     *  3.第二次遇到相同元素, 跳过
     *
     * */
    public int removeDuplicates(int[] nums) {
        int len =1;
        int counter =0;
        for(int i=1;i<nums.length;i++){
            if (nums[i]!=nums[i-1]){
                nums[len] = nums[i];//记录遍历到的值
                len++;
                counter=0;
            }else if (counter==0){
                nums[len] = nums[i];
                len++;
                counter++;
            }

        }
        return len;
    }
}
