import java.util.Stack;

/**
 * @author maple on 2019/11/18 9:27.
 * @version v1.0
 * @see 1040441325@qq.com
 * 85. 最大矩形
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * 输出: 6
 */
public class MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        int[][] heights = new int[matrix.length][matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            heights[0][j] = matrix[0][j] - '0';
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]=='1'){
                    heights[i][j] = heights[i - 1][j] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, largestRectangleArea(heights[i]));
        }

        return max;
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}}));
        System.out.println(maximalRectangle(new char[][]{{'0', '1'}, {'1', '0'}}));
    }
}
