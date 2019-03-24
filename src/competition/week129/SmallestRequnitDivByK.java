package competition.week129;

import java.util.HashSet;
import java.util.Set;

/**
 * @author maple on 2019/3/24 14:11.
 * @version v1.0
 * @see 1040441325@qq.com
 * 1022. 可被 K 整除的最小整数  显示英文描述
 * 用户通过次数 74
 * 用户尝试次数 262
 * 通过次数 75
 * 提交次数 1115
 * 题目难度 Medium
 * 给定正整数 K，你需要找出可以被 K 整除的、仅包含数字 1 的最小正整数 N。
 *
 * 返回 N 的长度。如果不存在这样的 N，就返回 -1。
 */
public class SmallestRequnitDivByK {
    public int smallestRepunitDivByK(int K) {
      if (K%2 ==0)return -1;
      int count1 =1,now =1;
      while (count1<K+10){
          now%=K;
          if (now==0)return count1;
          now=now*10+1;
          count1++;
      }
      return -1;
    }
}
