package QueueAndStack;

import java.util.*;

/**
 * 打开转盘锁
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 *
 */
public class OpenLock {
    public int openLock(String[] deadends, String target) {
        if (container("0000", deadends)) return -1;
        Queue<String> list = new LinkedList<>();
        Set<String> strings = new HashSet<>();
        list.offer("0000");
        strings.add("0000");
        int res = 0;
        while (list.size() > 0) {
            res++;
            int len = list.size();
            for (int i = 0; i < len; i++) {
                String t = list.poll();
                for (int j = 0; j < t.length(); j++) {
                    for (int k = -1; k <= 1; k += 2) {
                        // 执行操作
                        StringBuilder str = new StringBuilder(t);
                        str.deleteCharAt(j);
                        str.insert(j, (char) ((t.charAt(j) - '0' + k + 10) % 10 + '0'));
                        if (str.toString().equals(target)) return res;
                        if (!container(str.toString(), deadends) && !strings.contains(str.toString())) {
                            strings.add(str.toString());
                            list.offer(str.toString());
                        } else {
                            System.out.println(str.toString());
                        }
                    }
                }
            }
        }
        return -1;
    }

    private boolean container(String str, String[] deadends) {
        for (int i = 0; i < deadends.length; i++) {
            if (str.equals(deadends[i])) return true;
        }
        return false;
    }

    /****************************************方案2********************************************************************/
    public int openLock2(String[] deadends, String target) {
        boolean[] deads = new boolean[10000];
        boolean[] visiteds = new boolean[10000];
        for (int i = 0; i < deadends.length; i++) {
            deads[Integer.parseInt(deadends[i])] = true;
        }
        // 若'0000'在deadends中,返回 -1;
        if (deads[0]) return -1;
        int tar = Integer.parseInt(target);
        // 开始点及是结果
        if (tar == 0) return 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        visiteds[0] = true;
        int step = 0;
        while (queue.size() > 0) {
            step++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] nums = aroundNum(queue.poll());
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] == tar) return step;
                    if (!deads[nums[j]] && !visiteds[nums[j]]) {
                        queue.offer(nums[j]);
                        visiteds[nums[j]] = true;
                    }
                }
            }
        }
        return -1;
    }

    /**
     * 转动一位后可能的密码
     *
     * @param number 原密码
     * @return 可能密码组
     */
    private int[] aroundNum(int number) {
        int[] res = new int[8];
        int fir = number % 10;
        int sec = number % 100 / 10;
        int thi = number % 1000 / 100;
        int four = number / 1000;
        res[0] = (four + 10 - 1) % 10 * 1000 + thi * 100 + sec * 10 + fir;
        res[1] = (four + 1) % 10 * 1000 + thi * 100 + sec * 10 + fir;
        res[2] = four * 1000 + (thi + 10 - 1) % 10 * 100 + sec * 10 + fir;
        res[3] = four * 1000 + (thi + 1) % 10 * 100 + sec * 10 + fir;
        res[4] = four * 1000 + thi * 100 + (sec + 10 - 1) % 10 * 10 + fir;
        res[5] = four * 1000 + thi * 100 + (sec + 1) % 10 * 10 + fir;
        res[6] = four * 1000 + thi * 100 + sec * 10 + (fir + 10 - 1) % 10;
        res[7] = four * 1000 + thi * 100 + sec * 10 + (fir + 1) % 10;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new OpenLock().openLock2(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
    }
}
