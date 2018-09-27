/**
 * 跳跃游戏
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置
 */
public class CanJump {
    public static boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max<i)return false;
            if (nums[i]+i>max)max = nums[i]+i;
            if (max>=nums.length-1)return true;
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }
}
