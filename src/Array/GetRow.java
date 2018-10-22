package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角 2
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行
 */
public class GetRow {
    /**
     * 递归法
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            ArrayList list = new ArrayList();
            list.add(1);
            return list;
        } else {
            ArrayList list = new ArrayList();
            List<Integer> base = getRow(rowIndex - 1);
            list.add(1);
            for (int i = 0; i < rowIndex - 1; i++) {
                list.add(base.get(i) + base.get(i + 1));
            }
            list.add(1);
            return list;
        }
    }

    private List<Integer> getRow1(int rowIndex) {
        int temp = 1;
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            row.add(temp);
            temp = temp * (rowIndex - i) / (i + 1);
        }
        return row;
    }
}
