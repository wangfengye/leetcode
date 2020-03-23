import java.util.HashSet;

/**
 * 365. 水壶问题
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * <p>
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 * <p>
 * 你允许：
 * <p>
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 示例 1: (From the famous "Die Hard" example)
 * <p>
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 */
public class CCanMeasureWater {
    static HashSet<int[]> set;
    static boolean canMeasure;
    //递归过深 StackOverflowError;
    public static boolean canMeasureWater(int x, int y, int z) {
        set = new HashSet<>();
        canMeasure = false;
        due(x, y, z, 0, 0);
        return canMeasure;
    }

    private static void due(int x, int y, int z, int xL, int yL) {
        if (has(set, xL, yL)||canMeasure) return;
        set.add(new int[]{xL, yL});
        if (xL + yL == z) {
            canMeasure = true;
            return;
        }
        //装满x
        if (xL < x) {
            due(x, y, z, x, yL);
        }
        //装满y
        if (yL < y) {
            due(x, y, z, xL, y);
        }
        //清空x
        if (xL > 0) {
            due(x, y, z, 0, yL);
        }
        //清空y
        if (yL > 0) {
            due(x, y, z, xL, 0);
        }
        //x->y
        if(xL>0&&yL<y){
            int tmp =y-yL;
            if(xL>tmp){
                due(x, y, z, xL - (y - yL), y);
            }else {
                due(x,y,z,0,xL+yL);
            }

        }
        //y->x;
        if(xL<x&&yL>0){
            int tmp =x-xL;
            if(yL>tmp){
                due(x, y, z, x, yL-tmp);
            }else {
                due(x,y,z,xL+yL,0);
            }

        }


    }

    private static boolean has(HashSet<int[]> set, int xL, int yL) {
        for (int[] en : set) {
            if (en[0] == xL && en[1] == yL) return true;
        }
        return false;
    }

    /**
     * 问题本质 找到合适的a,b 使得 ax+by=z;
     * 而贝祖定理告诉我们，ax+by=zax+by=z 有解当且仅当 zz 是 x, yx,y 的最大公约数的倍数
     */

    public static boolean canMeasureWater1(int x, int y, int z){
        if (x + y < z) return false;
        if (x == 0 || y == 0)return z == 0 || x + y == z;

        return z % gcd(x, y) == 0;
    }
    private static int gcd(int m,int n){
        if (m < n) {// 保证m>n,若m<n,则进行数据交换
            int temp = m;
            m = n;
            n = temp;
        }
        if (m % n == 0) {// 若余数为0,返回最大公约数
            return n;
        } else { // 否则,进行递归,把n赋给m,把余数赋给n
            return gcd(n, m % n);
        }
    }


    public static void main(String[] args) {
        System.out.println(canMeasureWater(3, 5, 4));
        System.out.println(canMeasureWater(2, 6, 5));
        System.out.println(canMeasureWater(22003,
                31237, 1));
    }
}
