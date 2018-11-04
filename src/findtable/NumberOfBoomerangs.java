package findtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 回旋镖的数量
 * <p>
 * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中
 */
public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int counter =0;
        for (int i = 0; i < points.length; i++) {

            for (int j = 0; j < points.length; j++) {
                int dis = (int) (Math.pow(points[i][0] - points[j][0], 2)
                        + Math.pow(points[i][1] - points[j][1], 2));
               if (dis>0)map.put(dis,map.getOrDefault(dis,0)+1);
            }
            for (Map.Entry<Integer, Integer> entry:map.entrySet()){
                counter += entry.getValue()*(entry.getValue()-1);
            }
            map.clear();
        }


        return counter;
    }
}
