package competition.week128;

/**
 * @author maple on 2019/3/18 10:16.
 * @version v1.0
 * @see 1040441325@qq.com
 * 1013. 总持续时间可被 60 整除的歌曲  显示英文描述
 * 用户通过次数 450
 * 用户尝试次数 595
 * 通过次数 456
 * 提交次数 1236
 * 题目难度 Easy
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 *
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字  i < j 且有 (time[i] + time[j]) % 60 == 0。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[30,20,150,100,40]
 * 输出：3
 * 解释：这三对的总持续时间可被 60 整数：
 * (time[0] = 30, time[2] = 150): 总持续时间 180
 * (time[1] = 20, time[3] = 100): 总持续时间 120
 * (time[1] = 20, time[4] = 40): 总持续时间 60
 * 示例 2：
 *
 * 输入：[60,60,60]
 * 输出：3
 * 解释：所有三对的总持续时间都是 120，可以被 60 整数。
 */
public class NumPairsDivisibleBy60 {
    public static int numPairsDivisibleBy60(int[] time){
        int res=0;
        for (int i = 0; i < time.length; i++) {
            for (int j = i+1; j < time.length; j++) {
                if ((time[i]+time[j])%60==0)res++;
            }
        }
        return res;
    }
    public static int numPairsDivisibleBy60_1(int[] time){
        int res=0;
        int tmp[] = new int[60];//tmp[i] 余数是i的个数
        for (int i = 0; i < time.length; i++) {
            int t = time[i]%60;
            int r= t==0?t:60-t;
            res+= time[r];
            tmp[t]++;
        }
        return res;
    }
}
