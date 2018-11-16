package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 前K个高频元素
 * <p>
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素
 */
public class TopFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Integer num : nums) {
            if (num < min) min = num;
            if (num > max) max = min;
        }
        int[] counter = new int[max - min + 1];
        for (Integer num : nums) {
            counter[num - min]++;
        }
        int maxCount = 0;
        for (int count : counter) {
            if (count>maxCount)maxCount =count;
        }
        int[] keys = new int[maxCount + 1];   // 各个频数所包含的key数
        for (int key : counter) {
            keys[key]++;
        }
        int minCount =1;//求出取出频率前 k 高的元素中频率最小的元素数量
        int curr =0;
        for (int i = keys.length - 1; i >= 1; i--) {
            if (keys[i] > 0) {
                curr += keys[i];
                if (curr >= k) {
                    minCount = i;
                    break;
                }
            }
        }

        List<Integer> ans = new ArrayList<>(k);
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] >= minCount) {
                ans.add(i + min);
            }
        }
        return ans;
    }

    public List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer> res = new ArrayList<>();
        int index = 0;
        while (index < k) {
            int num = 0;
            int c = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > c) {
                    c = entry.getValue();
                    num = entry.getKey();
                }
            }
            map.remove((Integer) num);
            res.add(num);
            index++;
        }
        return res;
    }
}
