package bytedance;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author maple on 2019/2/21 16:02.
 * @version v1.0
 * @see 1040441325@qq.com
 * 俄罗斯套娃信封问题
 * <p>
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * <p>
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 */
public class MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length ==0)return 0;
        ArrayList<Envelope> list = new ArrayList<>();
        for (int i = 0; i < envelopes.length; i++) {
            list.add(new Envelope(envelopes[i][0], envelopes[i][1]));
        }
        Collections.sort(list);
        int[] ends = new int[envelopes.length];
        ends[0] = list.get(0).h;
        int right = 0;
        int l =0;
        int r =0;
        int m =0;
        for (int i = 0; i < list.size(); i++) {
            l=0;
            r = right;
            while (l<=r){
                m=(l+r)/2;
                if (list.get(i).h>ends[m]){
                    l=m+1;
                }else {
                    r= m-1;
                }
            }
            right = Math.max(right,l);
            ends[l]=list.get(i).h;
        }
        return right+1;
    }

    class Envelope implements Comparable<Envelope> {
        int w;
        int h;

        public Envelope(int w, int h) {
            this.w = w;
            this.h = h;
        }

        @Override
        public int compareTo(Envelope o) {
            if (w != o.w) {
                return w - o.w;
            } else {
                return o.h - h;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new MaxEnvelopes().maxEnvelopes(new int[][]{{2, 4}, {3, 6}, {3, 5}, {4, 6}}));
    }
}
