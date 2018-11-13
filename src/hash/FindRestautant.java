package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 两个列表的最小索引总和
 * <p>
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案
 */
public class FindRestautant {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        ArrayList<String> list =new ArrayList<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int base = -(list1.length + list2.length);
        int min = 0;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int res = base + i + map.get(list2[i]);
                if (min > res) {
                    min = res;
                    list.clear();
                    list.add(list2[i]);
                } else if (min == res) {
                    list.add(list2[i]);
                }
                map.put(list2[i], res);
            }
        }

        return list.toArray(new String[list.size()]);
    }
}
