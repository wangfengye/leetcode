package bytedance

import java.lang.StringBuilder

/**
 * 38. 外观数列
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。

注意：整数序列中的每一项将表示为一个字符串。
 */
class CountAndSay {
    fun countAndSay(n: Int): String {
        if (n == 1) return "1";
        val last = countAndSay(n - 1);
        val builder = StringBuilder();
        var tmp = ' ';
        var count = 0;
        for (c in last) {
            if (tmp != c) {
                if (count > 0) {
                    builder.append(count).append(tmp)
                }
                tmp = c
                count = 1
            } else {
                count++
            }
        }
        if (count > 0) {
            builder.append(count).append(tmp)
        }
        return builder.toString();
    }

    companion object {
        @JvmStatic
        public fun main(args: Array<String>) {
            println(CountAndSay().countAndSay(1))
            println(CountAndSay().countAndSay(4))
        }
    }
}