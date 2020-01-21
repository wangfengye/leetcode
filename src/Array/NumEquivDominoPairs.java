package Array;

/**
 * 1128. 等价多米诺骨牌对的数量
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 * <p>
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 * <p>
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 * <p>
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * 输出：1
 * 1 <= dominoes.length <= 40000
 * 1 <= dominoes[i][j] <= 9
 */
public class NumEquivDominoPairs {
    public int fun1(int[][] dominoes){
        //由于数值固定,使用邻接矩阵存数据
        int[][] linjie=new int[10][10];
        for (int i = 0; i < dominoes.length; i++) {
            linjie[dominoes[i][0]][dominoes[i][1]]++;
        }
        int count=0;
        for (int i = 0; i <10; i++) {
            count+=getCombinationAll(linjie[i][i]);
            for (int j = i+1; j < 10; j++) {
                count+=getCombinationAll(linjie[i][j]+linjie[j][i]);
            }
        }
        return count;
    }
    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        boolean[] loged = new boolean[dominoes.length];
        for (int i = 0; i < dominoes.length - 1; i++) {
            if (loged[i]) continue;
            loged[i] = true;
            int compareCount = 1;
            for (int j = i + 1; j < dominoes.length; j++) {
                if (compare(dominoes[i], dominoes[j])) {
                    loged[j] = true;
                    compareCount++;
                }
            }
            count += getCombinationAll(compareCount);
        }
        return count;
    }

    //:无需计算排列组合
    //排列组合,计算C(2,compareCount),
    private int getCombination(int compareCount) {
        int a = 1;//compareCount-2的阶乘
        for (int i = 2; i <= compareCount - 2; i++) {
            a *= i;
        }
        int b = a;//compareCount的阶乘
        b = b * (compareCount - 1) * compareCount;

        return b / (a * 2);
    }

    //全排列 A 的一半
    private int getCombinationAll(int compareCount) {
        if (compareCount<=1)return 0;
        if(compareCount==2)return 1;
        return compareCount*(compareCount-1) / 2;
    }

    private boolean compare(int[] d1, int[] d2) {
        return ((d1[0] == d2[0] && d1[1] == d2[1]) || (d1[0] == d2[1] && d1[1] == d2[0]));
    }

    public static void main(String[] args) {
        System.out.println(new NumEquivDominoPairs().numEquivDominoPairs(new int[][]{{1, 2}, {2, 1}, {3, 4}, {5, 6}}));
        System.out.println(new NumEquivDominoPairs().numEquivDominoPairs(new int[][]{{1,2},{1,2},{1,1},{1,2},{2,2}}));

        System.out.println(new NumEquivDominoPairs().fun1(new int[][]{{1, 2}, {2, 1}, {3, 4}, {5, 6}}));
        System.out.println(new NumEquivDominoPairs().fun1(new int[][]{{1,2},{1,2},{1,1},{1,2},{2,2}}));
    }
}
