import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 * <p>
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int row = matrix.length;
        int column = matrix[0].length;
        int cic = Math.min(row + 1, column + 1) / 2;//循环次数,即环的数量
        for (int i = 0; i < cic; i++, row -= 2, column -= 2) {
            // 向右
            for (int j = i; j < i + column; j++) {
                list.add(matrix[i][j]);
            }
            //向下
            for (int j = i + 1; j < i + row; j++) {
                list.add(matrix[j][i + column - 1]);
            }
            //若有一个方向数据只剩单行,则无需执行下一部分操作
            if (row == 1 || column == 1) break;
            //向左
            for (int j = i + column - 2; j >= i; j--) {
                list.add(matrix[i + row - 1][j]);
            }
            //向上
            for (int j = i + row - 2; j > i; j--) {
                list.add(matrix[j][i]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
         new SpiralOrder().spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
        new SpiralOrder().spiralOrder(new int[][]{{2,3,4},{5,6,7},{8,9,10},{11,12,13}});
        // StringBuilder优化
        String[] ss=new String[100000];
        for (int i = 0; i < 100000; i++) {
            ss[i] = "sfs"+i+"sdsdddddddgsgfsgf"+i;
        }
        System.out.print("string + : ");
        long timeStart = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            String a =ss[i]
                    + i;

        }
        System.out.println(System.currentTimeMillis() - timeStart);
        System.out.print("stringBuilder复用 : ");
        timeStart = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder(67);
        for (int i = 0; i < 100000; i++) {
            builder.setLength(0);
            builder.append(ss[i])
                    .append(i)
                    .toString();
        }
        System.out.println(System.currentTimeMillis() - timeStart);
        System.out.print("stringBuilder不复用 : ");
        timeStart = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            // 这应该是实际执行的 +
            new StringBuilder()
                    .append(ss[i])
                    .append(i).toString();

        }
        System.out.println(System.currentTimeMillis() - timeStart);
    }
}
