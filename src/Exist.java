import java.util.HashSet;

/**
 * @author maple on 2019/5/28 14:09.
 * @version v1.0
 * @see 1040441325@qq.com
 * 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 */
public class Exist {
    private HashSet<Integer> hashSet;

    public boolean exist(char[][] board, String word) {
        hashSet = new HashSet<>();
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (get(board, word, 0, i, j)) return true;
            }

        }
        return false;
    }

    private boolean get(char[][] board, String word, int id, int i, int j) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] == word.charAt(id)) {
            int tag = (i + 1) * board[i].length + j;
            if (!hashSet.add(tag)) return false;
            if (id+1==word.length())return true;
            boolean has = get(board, word, id + 1, i + 1, j)
                    || get(board, word, id + 1, i - 1, j)
                    || get(board, word, id + 1, i, j + 1)
                    || get(board, word, id + 1, i, j - 1);
            hashSet.remove(tag);
            return has;
        } else return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};

        System.out.println(new Exist().exist(board, "AS"));
        System.out.println(new Exist().exist(board, "ABCCED"));
        System.out.println(new Exist().exist(board, "SEE"));
        System.out.println(new Exist().exist(board, "ABCB"));
    }
}
