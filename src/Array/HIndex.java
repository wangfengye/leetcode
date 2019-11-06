package Array;

import java.util.Arrays;

/**
 * @author maple on 2019/11/5 16:41.
 * @version v1.0
 * @see 1040441325@qq.com
 * 274. H指数
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。
 *
 * h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）至多有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）”
 *
 *  
 *
 * 示例:
 *
 * 输入: citations = [3,0,6,1,5]
 * 输出: 3
 * 解释: 给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
 *      由于研究者有 3 篇论文每篇至少被引用了 3 次，其余两篇论文每篇被引用不多于 3 次，所以她的 h 指数是 3。
 *  
 * 275. H指数 II
 * 说明: 如果 h 有多种可能的值，h 指数是其中最大的那个。
 *
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照升序排列。编写一个方法，计算出研究者的 h 指数。
 *
 * h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）至多有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）"
 *
 *  
 *
 * 示例:
 *
 * 输入: citations = [0,1,3,5,6]
 * 输出: 3
 * 解释: 给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 0, 1, 3, 5, 6 次。
 *      由于研究者有 3 篇论文每篇至少被引用了 3 次，其余两篇论文每篇被引用不多于 3 次，所以她的 h 指数是 3。
 */
public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int res=0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[citations.length-1-i]>=i+1){
                res=i+1;
            }
        }
        return res;
    }
    public int hIndex2(int[] citations){
        if (citations.length==0)return 0;
        int l=0;
        int tmp=0;
        int r= citations.length;
        while (l<r){
            int m= (l+r)/2;
            if (citations[m]>=citations.length-m){
                r=m;
                tmp=citations.length-m;
            }else {
                l=m+1;
            }
        }
        return tmp;
    }
    public static void main(String[] args){
        System.out.println(new HIndex().hIndex(new int[]{3,0,6,1,5}));
        System.out.println(new HIndex().hIndex2(new int[]{0,1,3,5,6}));
        System.out.println(new HIndex().hIndex2(new int[]{0,1}));
    }
}
