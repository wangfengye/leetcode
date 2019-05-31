import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author maple on 2019/5/31 17:06.
 * @version v1.0
 * @see 1040441325@qq.com
 * Task Scheduler
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 * <p>
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * <p>
 * 你需要计算完成所有任务所需要的最短时间。
 * <p>
 * 示例 1：
 * <p>
 * 输入: tasks = ["A","A","A","B","B","B"], n = 2
 * 输出: 8
 * 执行顺序: A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
 * 注：
 * <p>
 * 任务的总个数为 [1, 10000]。
 * n 的取值范围为 [0, 100]。
 */
public class LeastInterval {
    static class Task {
        char t;
        int count;
        int wait;

        public Task(char t) {
            this.t = t;
        }
    }

    public static int leastInterval(char[] tasks, int n) {
        HashMap<Character, Task> map = new HashMap<>();
        for (char t : tasks) {
            Task task = map.getOrDefault(t, new Task(t));
            task.count++;
            map.put(t, task);
        }
        int time = 0;
        while (map.size() > 0) {
            time++;
            Iterator<Map.Entry<Character, Task>> it = map.entrySet().iterator();
            Task tmp = null;
            while (it.hasNext()) {
                Task task = it.next().getValue();
                if (task.wait <= 0) {
                    if (tmp == null) tmp = task;
                    else {
                        if (task.count > tmp.count) tmp = task;
                    }
                }
                task.wait--;
            }
            if (tmp != null) {
                tmp.count--;
                if (tmp.count == 0) map.remove(tmp.t);
                else tmp.wait = n;
            }

        }
        return time;
    }

    /**
     * AAABBCD,2 --> A**A**A   (c(A)-1)*2;
     * AAABBCDE,2 --> A**A**A*   (c(A)-1)+1;
     * AAABBBCCCDDD,2 ->ABCDABCDABCD  LEN
     *
     * 分析可知,当最多任务的数量的不同任务大于间隔时,可保证不等待,及结果为len,
     * 其他情况: （最多任务数-1）*（n + 1） + （相同最多任务的任务个数)
     * @param tasks 任务表
     * @param n 间隔时间
     * @return 完成时间
     */
    public static int leastInterval2(char[] tasks, int n) {
        int[] tmp = new int[26];
        for (char t : tasks) {
          tmp[t-'A']++;
        }
        Arrays.sort(tmp);
        int i = 25;
        while(i >=0 && tmp[i] == tmp[25]){
            i--;
        }
        return Math.max(tasks.length,(tmp[25] - 1) * (n + 1) + 25-i);
    }
    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        System.out.println(leastInterval2(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        System.out.println(leastInterval2(new char[]{'A', 'A', 'A', 'B', 'B', 'B','C','C','C','D','D','D'}, 2));
    }

}
