import java.util.*;

/**
 * 合并区间
 * <p>
 * 给出一个区间的集合，请合并所有重叠的区间
 */
public class Merge {
    List<Interval> mInterval;

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size()<2)return intervals;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        List<Interval> res = new ArrayList<>();
        Interval counter = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start<=counter.end){
                counter.end =Math.max(intervals.get(i).end,counter.end);
            }else {
                res.add(counter);
                counter = intervals.get(i);
            }
        }
        res.add(counter);
        return res;
    }
    public int[][] merge(int[][] intervals) {
        if(intervals.length<2)return intervals;
        //按起点排序(后面的区间,必然在前面区间的右侧),所有的区间只要与前面的尝试合并就行.
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        int[] lastTmp=intervals[0];//先取出一个,与后面的进行合并
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0]<=lastTmp[1]){
                lastTmp[1] =Math.max(intervals[i][1],lastTmp[1]);
            }else {
                res.add(lastTmp);
                lastTmp = intervals[i];
            }
        }
        res.add(lastTmp);
        int[][] resArr=new int[res.size()][];
        return res.toArray(resArr);
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}