package Array;

import java.util.Arrays;

/**
 * @author maple on 2019/11/7 9:39.
 * @version v1.0
 * @see 1040441325@qq.com
 * 135. 分发糖果
 * 师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * 示例 1:
 *
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 *
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 */
public class Candy {
    public static int candy(int[] ratings) {
        int sum=0;
        int[] l =new int[ratings.length];
        int[] r= new int[ratings.length];
        Arrays.fill(l,1);
        Arrays.fill(r,1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i]>ratings[i-1]){
                l[i]=l[i-1]+1;
            }
        }
        for (int i = ratings.length-2; i >=0; i--) {
            if (ratings[i]>ratings[i+1]){
                r[i]=r[i+1]+1;
            }
        }
        for (int i = 0; i < ratings.length; i++) {
            sum+=Math.max(l[i],r[i]);
        }
        return sum;
    }
    public static void main(String[] args){
        System.out.println(candy(new int[]{1,0,2}));
        System.out.println(candy(new int[]{1,2,2}));
    }
}
