package huawei.prefix;

/**
 * leetcode 1588
 *  出现前缀和解决问题的特征,只考虑连续子集.
 */
public class J1588 {
    public static void main(String[] args){
        System.out.println(sumOddLengthSubarrays(new int[]{1,4,2,5,3}));
        System.out.println(sumOddLengthSubarrays2(new int[]{1,4,2,5,3}));
    }
    public static int sumOddLengthSubarrays(int[] arr) {
        int[] preSum = new int[arr.length+1];
        // 求前缀和
        for (int i = 0; i < arr.length; i++) {
            preSum[i+1]=preSum[i]+arr[i];
        }
        int sum = 0;
        for (int i = 0; i <arr.length ; i++) {//起点
            for (int j =i; j < arr.length; j+=2) {//终点,step=2,保证奇数数量
                //终点的前缀和 - 起点之前的前缀后
                sum+= preSum[j+1]-preSum[i];
            }
        }
        return sum;
    }
    //TODO 最优解,找出规律,获取按要求的全排列后各个数字使用情况
    public static int sumOddLengthSubarrays2(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int leftCount = i, rightCount = n - i - 1;
            int leftOdd = (leftCount + 1) / 2;
            int rightOdd = (rightCount + 1) / 2;
            int leftEven = leftCount / 2 + 1;
            int rightEven = rightCount / 2 + 1;
            System.out.println(i+": "+leftCount+","+leftOdd+","+leftEven+","+rightCount+","+rightOdd+","+rightEven);
            sum += arr[i] * (leftOdd * rightOdd + leftEven * rightEven);
        }
        return sum;
    }
}
