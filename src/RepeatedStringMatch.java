/**
 * 686. 重复叠加字符串匹配
 * 给定两个字符串 A 和 B, 寻找重复叠加字符串A的最小次数，使得字符串B成为叠加后的字符串A的子串，如果不存在则返回 -1。
 * <p>
 * 举个例子，A = "abcd"，B = "cdabcdab"。
 * <p>
 * 答案为 3， 因为 A 重复叠加三遍后为 “abcdabcdabcd”，此时 B 是其子串；A 重复叠加两遍后为"abcdabcd"，B 并不是其子串。
 */
public class RepeatedStringMatch {
    /**
     * 双循环滚动遍历.
     * todo 还有种Rabin-Karp算法,暂时没看懂
     * @param A
     * @param B
     * @return
     */
    public static int repeatedStringMatch(String A, String B) {

        int id = -1;
        for (; ; ) {
            boolean flag = true;
            int count = 1;
            id = A.indexOf(B.charAt(0), id + 1);
            if (id == -1) return -1;
            int index=id;
            for (int i = 1; i < B.length(); i++) {
                if (index == A.length() - 1) {
                    count++;
                    index = 0;
                } else {
                    index++;
                }
                if (A.charAt(index) != B.charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) return count;
        }

    }

    public static void main(String[] args) {
        System.out.println(repeatedStringMatch("abcd", "cdabcdab"));
        System.out.println(repeatedStringMatch("aa", "a"));
        System.out.println(repeatedStringMatch("aaac", "aac"));
    }
}
