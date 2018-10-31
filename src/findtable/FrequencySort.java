package findtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列
 */
public class FrequencySort {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int counter = map.get(s.charAt(i)) + 1;
                if (counter > max) max = counter;
                map.put(s.charAt(i), counter);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        StringBuilder[] chars = new StringBuilder[max + 1];
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (chars[entry.getValue()] == null) chars[entry.getValue()] = new StringBuilder();
            for (int i = 0; i < entry.getValue(); i++) {
                chars[entry.getValue()].append(entry.getKey());
            }

        }
        StringBuilder res = new StringBuilder();
        for (int i = max; i > 0; i--) {
            if (chars[i]!=null)
            res.append(chars[i]);
        }
        return res.toString();
    }
    public String frequencySort2(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int start =0;
        int end =0;
        char temp = chars[start];
        StringBuilder[] builders = new StringBuilder[s.length()+1];
        while (end<chars.length){
            if (temp==chars[end]){
                end++;
            }
            else{

                if (builders[end-start]==null)builders[end-start] =new StringBuilder();
                builders[end-start].append(chars,start,end-start);
                start=end;
                end++;
                temp=chars[start];
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = builders.length; i > 0; i--) {
            if (builders[i]!=null)
                res.append(builders[i]);
        }
        return res.toString();
    }
    public static void main(String[] args){
       new FrequencySort().frequencySort2("tree");
    }
}
