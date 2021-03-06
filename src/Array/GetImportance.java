package Array;

import java.util.HashMap;
import java.util.List;

/**
 * @author maple on 2019/6/18 17:52.
 * @version v1.0
 * @see 1040441325@qq.com
 * 690. 员工的重要性
 * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
 * <p>
 * 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
 * <p>
 * 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * 输出: 11
 * 解释:
 * 员工1自身的重要度是5，他有两个直系下属2和3，而且2和3的重要度均为3。因此员工1的总重要度是 5 + 3 + 3 = 11。
 * 注意:
 * <p>
 * 一个员工最多有一个直系领导，但是可以有多个直系下属
 * 员工数量不超过2000。
 */
public class GetImportance {
    public int getImportance(List<Employee> employees, int id) {
        Employee e = null;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).id == id) {
                e = employees.get(i);
                break;
            }
        }
        if (e == null) return 0;
        if (e.subordinates == null) return e.importance;
        int sum = e.importance;
        for (int i = 0; i < e.subordinates.size(); i++) {
            sum += getImportance(employees, e.subordinates.get(i));
        }
        return sum;
    }

    public int getImportance1(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        return bfs(map, id);

    }

    private int bfs(HashMap<Integer, Employee> map, int id) {
        Employee e = map.get(id);
        if (e == null) return 0;
        if (e.subordinates == null) return e.importance;
        int sum = e.importance;
        for (int i = 0; i < e.subordinates.size(); i++) {
            sum += bfs(map, e.subordinates.get(i));
        }
        return sum;
    }

    public static void main(String[] a) {

    }

}

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
}