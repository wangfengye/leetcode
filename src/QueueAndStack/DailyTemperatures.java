package QueueAndStack;

import java.util.Stack;

/**
 * 每日温度
 * <p>
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高的天数。如果之后都不会升高，请输入 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的都是 [30, 100] 范围内的整数
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        int[] res = new int[temperatures.length];
        for (int i = 1; i < temperatures.length; i++) {
            while (stack.size() > 0) {
                if (temperatures[i] > temperatures[stack.peek()]) {
                    int preIndex = stack.pop();
                    res[preIndex] = i - preIndex;
                } else {
                    break;
                }
            }
            stack.push(i);
        }
        return res;
    }

    /**
     * 方案2
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures2(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for (int i = temperatures.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (temperatures[i] >= temperatures[j] && res[j] > 0) {
                j = j + res[j];
            }
            if (temperatures[i] < temperatures[j]) {
                res[i] = j - i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new DailyTemperatures().dailyTemperatures2(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }
}
