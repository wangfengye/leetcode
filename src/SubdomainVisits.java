import java.util.*;

/**
 * @author maple on 2019/6/3 15:04.
 * @version v1.0
 * @see 1040441325@qq.com
 * 811. 子域名访问计数
 * 别计算每个域名被访问的次数。其格式为访问次数+空格+地址，例如："9001 discuss.leetcode.com"。
 * <p>
 * 接下来会给出一组访问次数和域名组合的列表cpdomains 。要求解析出所有域名的访问次数，输出格式和输入格式相同，不限定先后顺序。
 * <p>
 * 示例 1:
 * 输入:
 * ["9001 discuss.leetcode.com"]
 * 输出:
 * ["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
 * 说明:
 * 例子中仅包含一个网站域名："discuss.leetcode.com"。按照前文假设，子域名"leetcode.com"和"com"都会被访问，所以它们都被访问了9001次。
 * 示例 2
 * 输入:
 * ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
 * 输出:
 * ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
 */
public class SubdomainVisits {
    public static List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] d = cpdomain.split(" ");
            int count = Integer.parseInt(d[0]);
            map.put(d[1], map.getOrDefault(d[1], 0) + count);
            int index = -1;
            while ((index = d[1].indexOf(".", index+1)) != -1) {
                String tmp = d[1].substring(index + 1);
                map.put(tmp, map.getOrDefault(tmp, 0) + count);
            }
        }
        List<String> res = new ArrayList<>();
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> e = it.next();
            res.add(e.getValue() + " " + e.getKey());
        }
        return res;
    }
    public static void main(String[] args){
        subdomainVisits(new String[]{"9001 discuss.leetcode.com"});
    }
}
