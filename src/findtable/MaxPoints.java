package findtable;

/**
 * 直线上最多的点数
 * <p>
 * 定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上
 */
public class MaxPoints {
    /**
     * 思路:三重for循环
     * 前两重循环 获得(a,b)两点的斜率,第三重取(a,c)的斜率若与前者相同则 c点在直线(a,b)上;
     */
    public int maxPoints(Point[] points) {
        if (points.length < 3) return points.length;
        int max =2;
        for (int i = 0; i < points.length; i++) {
            int samePosition =0;//重复的点
            int sameSlope =1;//斜率相同的点
            for (int j = i+1; j < points.length; j++) {
                int xDis = points[j].x - points[i].x;
                int yDis = points[j].y - points[i].y;
                if (xDis==0&&yDis==0)samePosition++;
                else {
                    sameSlope++;
                    for (int k = j+1; k <points.length ; k++) {
                        int xDis2 = points[k].x - points[i].x;
                        int yDis2 = points[k].y - points[i].y;

                        if ( xDis * yDis2 == xDis2 * yDis ) {// xDis/yDis = xDis2/yDis2;
                            sameSlope++;
                        }
                    }
                }
                if(max < (samePosition + sameSlope)){
                    max = samePosition + sameSlope;
                }
                sameSlope = 1;
            }
        }return max;
    }

    public static void main(String[] args) {
        new MaxPoints().maxPoints(new Point[]{new Point(0, 0), new Point(1, 1), new Point(1, -1)});
    }
}

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}