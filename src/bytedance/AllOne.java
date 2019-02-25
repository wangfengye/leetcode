package bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @author maple on 2019/2/25 14:12.
 * @version v1.0
 * @see 1040441325@qq.com
 */
public class AllOne {
    public HashMap<String, Integer> map;
    private String max;
    private String min;

    /**
     * Initialize your data structure here.
     */
    public AllOne() {
        map = new HashMap<>();
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        map.put(key, map.getOrDefault(key, 0) + 1);

    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        if (map.getOrDefault(key, 0) == 1) {
            map.remove(key);
        } else {
            map.put(key, map.getOrDefault(key, 0) - 1);
        }

    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        int max =0;
        String key="";
        for (Map.Entry<String, Integer> entry:
        map.entrySet()){
            if (max<entry.getValue()){
                max = entry.getValue();
                key = entry.getKey();
            }
        }
        return key;
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        int min =Integer.MAX_VALUE;
        String key="";
        for (Map.Entry<String, Integer> entry:
                map.entrySet()){
            if (min>entry.getValue()){
                min = entry.getValue();
                key = entry.getKey();
            }
        }
        return key;
    }
}
