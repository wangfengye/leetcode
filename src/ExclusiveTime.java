import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author maple on 2019/6/5 10:18.
 * @version v1.0
 * @see 1040441325@qq.com
 * 636. 函数的独占时间
 * 给出一个非抢占单线程CPU的 n 个函数运行日志，找到函数的独占时间。
 * <p>
 * 每个函数都有一个唯一的 Id，从 0 到 n-1，函数可能会递归调用或者被其他函数调用。
 * <p>
 * 日志是具有以下格式的字符串：function_id：start_or_end：timestamp。例如："0:start:0" 表示函数 0 从 0 时刻开始运行。"0:end:0" 表示函数 0 在 0 时刻结束。
 * <p>
 * 函数的独占时间定义是在该方法中花费的时间，调用其他函数花费的时间不算该函数的独占时间。你需要根据函数的 Id 有序地返回每个函数的独占时间。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * n = 2
 * logs =
 * ["0:start:0",
 * "1:start:2",
 * "1:end:5",
 * "0:end:6"]
 * 输出:[3, 4]
 * 说明：
 * 函数 0 在时刻 0 开始，在执行了  2个时间单位结束于时刻 1。
 * 现在函数 0 调用函数 1，函数 1 在时刻 2 开始，执行 4 个时间单位后结束于时刻 5。
 * 函数 0 再次在时刻 6 开始执行，并在时刻 6 结束运行，从而执行了 1 个时间单位。
 * 所以函数 0 总共的执行了 2 +1 =3 个时间单位，函数 1 总共执行了 4 个时间单位。
 * 说明：
 * <p>
 * 输入的日志会根据时间戳排序，而不是根据日志Id排序。
 * 你的输出会根据函数Id排序，也就意味着你的输出数组中序号为 0 的元素相当于函数 0 的执行时间。
 * 两个函数不会在同时开始或结束。
 * 函数允许被递归调用，直到运行结束。
 * 1 <= n <= 100
 */
public class ExclusiveTime {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<int[]> stack = new Stack<>();//int[] 三个数据:id,startime,usedtime
        int[] res = new int[n];
        for (String log : logs) {
            String[] tmp = log.split(":");
            if (tmp[1].equals("start")) {
                stack.push(new int[]{Integer.parseInt(tmp[0]), Integer.parseInt(tmp[2]), 0});
            } else {
                int[] p = stack.pop();
                int t = Integer.parseInt(tmp[2]) - p[1] + 1 - p[2];
                res[p[0]] += t;
                if (stack.size() > 0) {
                    int[] parent = stack.peek();
                    parent[2] += (p[2] + t);
                }
            }
        }
        return res;
    }


    public static void main(String[] a) {
        ArrayList<String> d = new ArrayList<>();
        d.add("0:start:0");
        d.add("1:start:2");
        d.add("1:end:5");
        d.add("0:end:6");
        new ExclusiveTime().exclusiveTime(2, d);
    }
}
