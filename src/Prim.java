/**
 * Java: prim算法生成最小生成树(邻接矩阵)
 */

import java.util.*;

public class Prim {

    private char[] mVexs;       // 顶点集合
    private int[][] mMatrix;    // 邻接矩阵
    private static final int INF = Integer.MAX_VALUE;   // 最大值
    private char[] prims;


    /*
     * 创建图(用已提供的矩阵)
     *
     * 参数说明：
     *     vexs  -- 顶点数组
     *     matrix-- 矩阵(数据)
     */
    public Prim(char[] vexs, int[][] matrix) {

        // 初始化"顶点数"和"边数"
        int vlen = vexs.length;

        // 初始化"顶点"
        mVexs = new char[vlen];
        for (int i = 0; i < mVexs.length; i++)
            mVexs[i] = vexs[i];

        // 初始化"边"
        mMatrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++)
            for (int j = 0; j < vlen; j++)
                mMatrix[i][j] = matrix[i][j];
    }

    /*
     * 返回ch位置
     */
    private int getPosition(char ch) {
        for (int i = 0; i < mVexs.length; i++)
            if (mVexs[i] == ch)
                return i;
        return -1;
    }

    /*
     * 打印矩阵队列图
     */
    public void print() {
        System.out.print("Martix Graph:\n");
        for (int j = 0; j < mVexs.length; j++) {
            System.out.print("         " + (char) ('A' + j) + " ");
        }

        System.out.println();
        for (int i = 0; i < mVexs.length; i++) {
            for (int j = 0; j < mVexs.length; j++) {
                System.out.printf("%10d ", mMatrix[i][j]);
            }
            System.out.println();
        }
    }

    /*
     * prim最小生成树
     *
     * 参数说明：
     *   start -- 从图中的第start个元素开始，生成最小树
     */
    public void prim(int start) {
        int num = mVexs.length;         // 顶点个数
        int index = 0;                    // prim最小树的索引，即prims数组的索引
        prims = new char[num];  // prim最小树的结果数组
        int[] weights = new int[num];   // 顶点间边的权值

        // prim最小生成树中第一个数是"图中第start个顶点"，因为是从start开始的。
        prims[index++] = mVexs[start];

        // 初始化"顶点的权值数组"，
        // 将每个顶点的权值初始化为"第start个顶点"到"该顶点"的权值。
        for (int i = 0; i < num; i++)
            weights[i] = mMatrix[start][i];
        // 将第start个顶点的权值初始化为0。
        // 可以理解为"第start个顶点到它自身的距离为0"。
        weights[start] = 0;

        for (int i = 0; i < num; i++) {
            // 由于从start开始的，因此不需要再对第start个顶点进行处理。
            if (start == i)
                continue;

            int j = 0;
            int k = 0;
            int min = INF;
            // 在未被加入到最小生成树的顶点中，找出权值最小的顶点。
            while (j < num) {
                // 若weights[j]=0，意味着"第j个节点已经被排序过"(或者说已经加入了最小生成树中)。
                if (weights[j] != 0 && weights[j] < min) {
                    min = weights[j];
                    k = j;
                }
                j++;
            }

            // 经过上面的处理后，在未被加入到最小生成树的顶点中，权值最小的顶点是第k个顶点。
            // 将第k个顶点加入到最小生成树的结果数组中
            prims[index++] = mVexs[k];
            // 将"第k个顶点的权值"标记为0，意味着第k个顶点已经排序过了(或者说已经加入了最小树结果中)。
            weights[k] = 0;
            // 当第k个顶点被加入到最小生成树的结果数组中之后，更新其它顶点的权值。
            for (j = 0; j < num; j++) {
                // 当第j个节点没有被处理，并且需要更新时才被更新。
                if (weights[j] != 0 && mMatrix[k][j] < weights[j])
                    weights[j] = mMatrix[k][j];
            }
        }

        // 计算最小生成树的权值

        int sum = 0;
        for (int i = 1; i < index; i++) {
            int min = INF;
            int mM = 0;//计入路径的m
            // 获取prims[i]在mMatrix中的位置
            int n = getPosition(prims[i]);
            // 在vexs[0...i]中，找出到j的权值最小的顶点。
            for (int j = 0; j < i; j++) {
                int m = getPosition(prims[j]);
                if (mMatrix[m][n] < min) {
                    min = mMatrix[m][n];
                    mM = m;
                }
            }
            System.out.print(mVexs[mM] + "->" + mVexs[n] + " ");
            sum += min;
        }
        // 打印最小生成树
        System.out.printf("\n权值(%c)=%d; ", mVexs[start], sum);

        System.out.printf("\n");
    }

    /**
     * 求某个点到其他点的平均路径
     *
     * @param i 选择的点
     * @return 路径权值平均.
     */
    private int averageLoad(int i) {
        int sum = 0;
        for (int j = 0; j < mVexs.length; j++) {
            if (j == i) continue;
            sum += showRoad(mVexs[i], mVexs[j], false);
        }
        return sum / mVexs.length - 1;
    }

    /**
     * 基于已生成的方案求两点路径
     */
    private int showRoad(char a, char b, boolean print) {
        int pa = -1;
        int pb = -1;
        for (int i = 0; i < mVexs.length; i++) {
            if (a == mVexs[i]) pa = i;
            if (b == mVexs[i]) pb = i;
        }
        ArrayList<Edge> res = new ArrayList();

        for (int i = 0; i < load.size(); i++) {
            int nextP = load.get(i).from(pa);
            if (nextP == pb) {
                res.add(load.get(i));
                break;
            } else if (nextP != -1) {
                res.add(load.get(i));
                if (getload(nextP, pb, res)) break;
                res.remove(res.size() - 1);
            }
        }
        int sum = 0;
        for (int i = 0; i < res.size(); i++) {
            sum += res.get(i).level;
            if (print) System.out.print(mVexs[res.get(i).start] + "->" + mVexs[res.get(i).end] + " ");
        }
        if (print) System.out.println("路径和: " + sum);
        return sum;
    }

    private boolean getload(int pa, int pb, ArrayList<Edge> res) {
        for (int i = 0; i < load.size(); i++) {
            if (res.contains(load.get(i))) continue;
            int nextP = load.get(i).from(pa);
            if (nextP == pb) {
                res.add(load.get(i));
                return true;
            } else if (nextP != -1) {
                res.add(load.get(i));
                if (getload(nextP, pb, res)) {
                    return true;
                } else {
                    res.remove(res.size() - 1);
                }
            }
        }
        return false;
    }

    public static class Edge {
        int start;
        int end;
        int level;

        public Edge(int start, int end, int level) {
            this.start = start;
            this.end = end;
            this.level = level;
        }

        // 判断路线包含改点,返回路线另外一点.;否则返回-1;
        private int from(int p) {
            if (p == start) return end;
            else if (p == end) return start;
            return -1;
        }
    }

    /**
     * 克鲁斯卡尔（Kruskal）算法
     */
    ArrayList<Edge> load;

    private void kruskal() {
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = i + 1; j < 10; j++) {
                edges.add(new Edge(i, j, mMatrix[i][j]));
            }
        }
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.level - o2.level;
            }
        });
        int[] cachePoints = new int[mVexs.length];
        load = new ArrayList<>();
        int sum = 0;
        int n, m;
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
            n = check(cachePoints, edge.start);
            m = check(cachePoints, edge.end);
            if (n != m) {//保证无环路
                cachePoints[n] = m;
                sum += edge.level;
                load.add(edge);
            }
        }
        for (int i = 0; i < load.size(); i++) {
            System.out.print(mVexs[load.get(i).start] + "->" + mVexs[load.get(i).end] + " ");

        }
        showAsTree(new ArrayList<>(load));

        System.out.println("\n权值和:" + sum);

    }

    private void showAsTree(ArrayList<Edge> load) {
        Node root = new Node(load.get(0).start);
        ArrayList<Integer> toDel = new ArrayList<>();
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.offer(root);
        int nodeSize = 0;
        while ((nodeSize = nodes.size()) > 0) {
            while (nodeSize > 0) {
                toDel.clear();
                nodeSize--;
                Node node = nodes.pop();
                for (int j = 0; j < load.size(); j++) {
                    Edge e = load.get(j);
                    if (e.start == node.val) {
                        toDel.add(j);
                        node.children.add(new Node(e.end));
                    } else if (e.end == node.val) {
                        toDel.add(j);
                        node.children.add(new Node(e.start));
                    }
                }
                nodes.addAll(node.children);
                for (int j = toDel.size() - 1; j >= 0; j--) {
                    load.remove((int) toDel.get(j));//Integer被当做对象,一直删除失败
                }
            }
        }
        root.show();
    }

    public static class Node {
        int val;
        ArrayList<Node> children;

        public Node(int val) {
            this.val = val;
            children = new ArrayList<>();
        }

        void show() {
            System.out.println();
            LinkedList<Node> nodes = new LinkedList<>();
            nodes.offer(this);
            int nodeSize = 0;
            while ((nodeSize = nodes.size()) > 0) {
                /** 括号给元素分组,
                 *  demo
                 *  (GH)( I)
                 * ()(C,A)()
                 * C,A对应上面的H
                 */


                System.out.print("(");
                for (int i = 0; i < nodeSize; i++) {
                    Node node = nodes.pop();
                    if (node.val==-1){
                        System.out.print(")");
                        if (i<nodeSize-1)System.out.print("(");
                    }else {
                        System.out.print((char) (node.val + 'A') + " ");
                        nodes.addAll(node.children);
                        nodes.add(new Node(-1));//用作分隔符
                    }

                }
                System.out.println();
            }


        }
    }

    public int check(int[] cachePoints, int index) {
        while (cachePoints[index] > 0) {
            index = cachePoints[index];
        }
        return index;
    }

    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        int matrix[][] = new int[10][10];
        for (int i = 0; i < 10; i++) {//生成随机路径(随机值1~99)
            for (int j = i + 1; j < 10; j++) {
                matrix[i][j] = (int) (Math.random() * 99) + 1;
            }
        }
        for (int i = 0; i < 10; i++) {//无向图,双向路径相同,填充相反路基的值
            for (int j = i + 1; j < 10; j++) {
                matrix[j][i] = matrix[i][j];
            }
        }
        Prim pG;
        // 自定义"图"(输入矩阵队列)
        //pG = new MatrixUDG();
        // 采用已有的"图"
        pG = new Prim(vexs, matrix);

        pG.print();   // 打印图
        System.out.println("最小树生成(Prim):");
        pG.prim(0);
        System.out.println("最小树生成(Kruskal):");
        pG.kruskal();
        System.out.println("选合适的修建点:");
        int min = Integer.MAX_VALUE;
        int minId = -1;
        for (int i = 0; i < vexs.length; i++) {
            int avg = pG.averageLoad(i);
            if (avg < min) {
                min = avg;
                minId = i;
            }
            System.out.println(pG.mVexs[i] + "点平均路径权值: " + avg);
        }
        System.out.println("推荐修建点: " + pG.mVexs[minId]);
        System.out.println("求A->B路线: ");
        pG.showRoad('A', 'B', true);
    }
}