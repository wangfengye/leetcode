package bytedance

import java.util.*

/**
 * Longest Substring Without Repeating Characters
 * Description
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * Given "bbbbb", the answer is "b", with the length of 1.
 *
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Tags: Hash Table, Two Pointers, String
 *
 * 思路
 * 题意是计算不带重复字符的最长子字符串的长度，开辟一个 hash 数组来存储该字符上次出现的位置，比如 hash[a] = 3 就是代表 a 字符前一次出现的索引在 3，遍历该字符串，获取到上次出现的最大索引（只能向前，不能退后），与当前的索引做差获取的就是本次所需长度，从中迭代出最大值就是最终答案
 */
object LengthOfLongestSubstring {
    fun lengthOfLongestSubstring(s: String): Int {
        var max = 0
        val chars = s.toCharArray()
        val keys = HashMap<Char, Int?>()
        var last = 0
        for (i in chars.indices) {
            if (keys.containsKey(chars[i])) {
                val len = i - last
                if (max < len) max = len
                last = keys[chars[i]]!! + 1
                val it: MutableIterator<Map.Entry<Char, Int?>> = keys.entries.iterator()
                while (it.hasNext()) {
                    val entry = it.next()
                    if (entry.value!! < last) {
                        it.remove()
                    }
                }
            }
            keys[chars[i]] = i
        }
        max = Math.max(s.length - last, max)
        return max
    }

    fun lengthOfLongestSubstring2(s: String?): Int {
        var len: Int=0
        if (s == null || s.length.also { len = it } == 0) return 0
        //preP记录有效的起始点.
        var preP = 0
        var max = 0
        val hash = IntArray(128)
        for (i in  0 until  len) {
            val c = s[i]
            if (hash[c.toInt()] > preP) { //更新起点
                preP = hash[c.toInt()]
            }
            //更新hash数组
            hash[c.toInt()] = i + 1
            //计算当前长度.
            val l = i - preP + 1
            if (l > max) max = l
        }
        return max
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(lengthOfLongestSubstring2("abcabcbb"))
        println(lengthOfLongestSubstring2("bbbbb"))
        println(lengthOfLongestSubstring2("pwwkew"))
        println(lengthOfLongestSubstring2("pwwpew"))
    }
}