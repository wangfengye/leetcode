package Array;

import java.util.*;

/**
 * @author maple on 2019/12/11 11:49.
 * @version v1.0
 * @see 1040441325@qq.com
 * 506. 相对名次
 * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
 *
 * (注：分数越高的选手，排名越靠前。)
 *
 * 示例 1:
 *
 * 输入: [5, 4, 3, 2, 1]
 * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
 * 余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
 */
public class FindRelativeRanks {
    public static String[] findRelativeRanks(int[] nums) {
        String[] res =new String[nums.length];
        ArrayList<int[]> list=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new int[]{i,nums[i]});
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return -(o1[1]-o2[1]);
            }
        });
        for (int i = 0; i < res.length; i++) {
            if (i==0)  res[list.get(i)[0]]="Gold Medal";
            else if (i==1)  res[list.get(i)[0]]="Silver Medal";
            else if (i==2)  res[list.get(i)[0]]="Bronze Medal";
            else res[list.get(i)[0]]=String.valueOf(i+1);
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{5,4,3,2,1})));
    }
}
