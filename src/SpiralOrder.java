import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 螺旋矩阵
 *
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int i = 1;
        int xMax = matrix[0].length  - 1;//极限值
        int yMax = matrix.length - 1;//极限值
        int x = 0;
        int y = 0;
        int xStep = 1;//步长
        int yStep = 0;
        boolean middleX =false;
        boolean middleY =false;
        while (i <= matrix[0].length*matrix.length) {
            i++;
            list.add(matrix[y][x]);
            if (x == xMax&&!middleX) {
                // x轴走完拐弯,计算下次x轴遍历重点
                if (xStep == 1) xMax =  matrix[0].length - 1 - xMax;
                else xMax =  matrix[0].length - 1 - xMax - 1;
                //拐弯后y轴步长
                yStep = xStep;
                xStep = 0;
                if(xMax*2+1==matrix[0].length)middleX=true;
            }
            if (y == yMax&&!middleY) {
                if (yStep == 1) yMax =  matrix.length - 1 - (yMax - 1);
                else yMax =  matrix.length - 1 - yMax;
                xStep = -yStep;
                yStep = 0;
                if(yMax*2+1==matrix.length)middleY=true;
            }
            x += xStep;
            y += yStep;
        }
        return list;
    }
    public static void main (String[] args){
        // new SpiralOrder().spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
        String pattern = "a[0-9a-f]{3}";

        Pattern r = Pattern.compile(pattern);
        String data ="a4e22";
        Matcher m = r.matcher(data);

        System.out.print(m.find());
    }
}
