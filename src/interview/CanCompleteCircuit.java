package interview;

/**
 * @author maple on 2019/3/6 10:12.
 * @version v1.0
 * @see 1040441325@qq.com
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * <p>
 * 说明:
 * <p>
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 */
public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int mx = -1;
        int start = 0;
        for (int i = gas.length - 1; i >= 0; i--) {//遍历找到剩余量最大的点
            total += gas[i] - cost[i];
            if (total > mx) {
                start = i;
                mx = total;
            }
        }
        return total < 0 ? -1 : start;
    }

    // 正向计算
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int runned = 0;
        int total = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            runned += gas[i] - cost[i];
            if (runned < 0) {
                start = i + 1;
                runned = 0;
            }
            total += gas[i] - cost[i];
        }
        return total < 0 ? -1 : start;
    }
}
