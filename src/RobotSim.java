/**
 * @author maple on 2019/6/2 16:36.
 * @version v1.0
 * @see 1040441325@qq.com
 * 874. 模拟行走机器人
 * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 * <p>
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物。
 * <p>
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 * <p>
 * 如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 * <p>
 * 返回从原点到机器人的最大欧式距离的平方。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: commands = [4,-1,3], obstacles = []
 * 输出: 25
 * 解释: 机器人将会到达 (3, 4)
 * 示例 2：
 * <p>
 * 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出: 65
 * 解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
 */
public class RobotSim {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] point = new int[]{0, 0};
        int direction = 0;//0-3 四个方向
        int max = 0;
        for (int commmand : commands) {
            switch (commmand) {
                case -2:
                    direction = (direction + 3) % 4;
                    break;
                case -1:
                    direction = (direction + 1) % 4;
                    break;
                default:
                    point = action(point, obstacles, direction, commmand);
                    int tmp =point[0] * point[0] + point[1] * point[1];
                    if (tmp>max)max=tmp;
                    break;
            }
        }
        return max;
    }

    private int[] action(int[] point, int[][] obstacles, int direction, int command) {
        int d2 = direction % 2;
        int d1 = (direction + 1) % 2;
        if (direction > 1) {
            int min = point[d1] - command;
            for (int[] o : obstacles) {
                if (o[d2] == point[d2]) {
                    if (o[d1] < point[d1] && o[d1] >= min) {
                        min = o[d1] + 1;
                    }
                }
            }
            point[d1] = min;
        } else {
            int min = point[d1] + command;
            for (int[] o : obstacles) {
                if (o[d2] == point[d2]) {
                    if (o[d1] > point[d1] && o[d1] <= min) {
                        min = o[d1] - 1;
                    }
                }
            }
            point[d1] = min;
        }
        return point;
    }

    public static void main(String[] at) {
        System.out.println(new RobotSim().robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{{2, 4}}));
        System.out.println(new RobotSim().robotSim(new int[]{4, -1, 3}, new int[][]{}));
    }
}
