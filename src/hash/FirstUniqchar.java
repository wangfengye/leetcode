package hash;

/**
 * 字符串中的第一个唯一字符
 */
public class FirstUniqchar {
    public int firstUniqChar(String s) {
        int[] base = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i) - 'a';
            base[temp]++;
        }
        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i) - 'a';
            if (base[temp] == 1) return i;
        }
        return -1;
    }

    /**
     * 利用string的 indexOf,lastIndexOf
     * @param s
     * @return
     */
    public int firstUniqChar1(String s) {
        int res = -1;
        for(char ch='a'; ch<='z'; ch++) {
            int index = s.indexOf(ch);
            if(index != -1 && index == s.lastIndexOf(ch)) {
                res = res == -1?index:Math.min(res, index);
            }
        }

        return res;
    }
}
