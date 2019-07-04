package Array;

import java.util.ArrayList;

/**
 * @author maple on 2019/7/4 9:21.
 * @version v1.0
 * @see 1040441325@qq.com
 * 57. 插入区间
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 * <p>
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
public class Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        boolean due = false;
        for (int i = 0; i < intervals.length; i++) {
            int[] tmp = intervals[i];
            if (due) {
                res.add(tmp);
                continue;
            }
            if (tmp[1] < newInterval[0]) {
                res.add(tmp);
            } else if (tmp[0] > newInterval[1]) {
                res.add(newInterval);
                res.add(tmp);
                due = true;
            } else {
                newInterval[0] = Math.min(tmp[0], newInterval[0]);
                newInterval[1] = Math.max(tmp[1], newInterval[1]);
            }
        }
        if (!due)res.add(newInterval);
        int[][] resArray = new int[res.size()][];
        return res.toArray(resArray);
    }
}
