package Array;

import java.util.Arrays;

/**
 * @author maple on 2019/11/5 17:28.
 * @version v1.0
 * @see 1040441325@qq.com
 * 1103. 分糖果 II
 * 排排坐，分糖果。
 *
 * 我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
 *
 * 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
 *
 * 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。
 *
 * 重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。
 *
 * 返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：candies = 7, num_people = 4
 * 输出：[1,2,3,1]
 * 解释：
 * 第一次，ans[0] += 1，数组变为 [1,0,0,0]。
 * 第二次，ans[1] += 2，数组变为 [1,2,0,0]。
 * 第三次，ans[2] += 3，数组变为 [1,2,3,0]。
 * 第四次，ans[3] += 1（因为此时只剩下 1 颗糖果），最终数组变为 [1,2,3,1]。
 */
public class DistributeCandies {
    public int[] distributeCandies(int candies, int num_people) {
        int floor=0;
        for(;;){
            int canTmp= (num_people+1)*num_people/2+floor*num_people*num_people;
                if (candies>=canTmp){
                    candies-=canTmp;
                    floor++;
            }else {
                break;
            }
        }
        int res[] =new int[num_people];
        for (int i = 0; i < num_people; i++) {
            res[i]=floor*(floor-1)/2*num_people+floor*(i+1);
            int except = floor*num_people+i+1;
            if (candies>=except){
                res[i]+=except;
                candies-=except;
            }else {
                res[i]+=candies;
                candies=0;
            }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(Arrays.toString(new DistributeCandies().distributeCandies(7,4)));
        System.out.println(Arrays.toString(new DistributeCandies().distributeCandies(60,4)));
    }
}
