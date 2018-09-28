import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

    private boolean merge2(Interval a, Interval b) {
        if (a.start <= b.start && a.end >= b.start
                || b.start <= a.start && b.end >= a.start) {
            a.start = Math.min(a.start, b.start);
            a.end = Math.max(b.start, b.end);
            return true;
        }
        return false;
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