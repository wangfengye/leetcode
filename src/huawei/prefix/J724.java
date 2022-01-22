package huawei.prefix;

public class J724 {
    public static void main(String[] args){
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }
    public static int pivotIndex(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (preSum[nums.length] - preSum[i+1] == preSum[i]) {
                return i;
            }
        }
        return -1;
    }
}
