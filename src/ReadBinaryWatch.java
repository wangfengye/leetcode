import java.util.ArrayList;
import java.util.List;

/**
 * @author maple on 2019/7/11 9:35.
 * @version v1.0
 * @see 1040441325@qq.com
 * 401. 二进制手表
 * 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
 * <p>
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 * <p>
 * <p>
 * <p>
 * 例如，上面的二进制手表读取 “3:25”。
 * <p>
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 * <p>
 * 案例:
 * <p>
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 */
public class ReadBinaryWatch {
    ArrayList<String> data;

    public List<String> readBinaryWatch(int num) {
        int[] tmp = new int[10];
        data = new ArrayList<>();
        dfs(tmp, num, 0);
        return data;
    }

    private void dfs(int[] tmp, int num, int id) {
        if (num == 0) {
            addNum(tmp);return;
        }
        if (num > tmp.length - id) return;
        for (int i = id; i < tmp.length; i++) {
            tmp[i] = 1;
            dfs(tmp, num - 1, i+1);
            tmp[i] = 0;
        }
    }

    private void addNum(int[] tmp) {
        int hour = 0;
        for (int i = 0; i < 4; i++) {
            hour = hour * 2 + tmp[i];
        }
        if (hour > 11) return;
        int minute = 0;
        for (int i = 4; i < 10; i++) {
            minute = minute * 2 + tmp[i];
        }
        if (minute > 59) return;
        if (minute < 10) data.add(hour + ":0" + minute);
        else data.add(hour + ":" + minute);

    }
}
