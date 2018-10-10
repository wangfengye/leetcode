package Array;

/**
 * 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int a = -1;
        int b = -1;
        int c = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[++c] = 2;
                nums[++b] = 1;
                nums[++a] = 0;
            } else if (nums[i] == 1) {
                nums[++c] = 2;
                nums[++b] = 1;
            } else {
                nums[++c] = 2;
            }
        }
    }

    //两次遍历,第一次记录数量,第二次重排
    public void sortColors1(int[] nums) {
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) a++;
            else if (nums[i] == 1) b++;
            else c++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < a) nums[i] = 0;
            else if (i < a + b) nums[i] = 1;
            else nums[i] = 2;
        }
    }

    public void sortColors2(int[] nums) {
        int i = 0;
        int lt = -1;
        int gt = nums.length;
        while (i < gt) {
            if (nums[i] == 0) {
                lt++;
                // i,lt交互
                nums[i] = nums[lt];
                nums[lt] = 0;
                i++;
            } else if (nums[i] == 2) {
                gt--;
                nums[i] = nums[gt];
                nums[gt] = 2;
            } else {
                i++;
            }
        }
    }
    public static void main(String[] args){
        new SortColors().sortColors2(new int[]{2,0,1,1,0});
    }
}
