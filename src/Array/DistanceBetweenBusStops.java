package Array;

/**
 * 1184. 公交站间的距离
 * 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
 * <p>
 * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
 * <p>
 * 返回乘客从出发点 start 到目的地 destination 之间的最短距离。
 */
public class DistanceBetweenBusStops {
    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int maxDis = 0;
        int dis = 0;
        for (int i = start; i < start + distance.length; i++) {

            if (i % distance.length == destination) {
                maxDis = dis;
                dis = 0;
            }
            dis += distance[i % distance.length];
        }
        return Math.min(dis, maxDis);
    }
    public static void main(String[] args){
        distanceBetweenBusStops(new int[]{1,2,3,4},0,3);
    }
}
