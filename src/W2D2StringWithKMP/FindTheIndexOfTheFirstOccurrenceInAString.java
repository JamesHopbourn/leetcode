package W2D2StringWithKMP;

import common.PrintUtil;

/**
 * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string
 * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/solution/shua-chuan-lc-shuang-bai-po-su-jie-fa-km-tb86/
 * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/solution/dai-ma-sui-xiang-lu-kmpsuan-fa-xiang-jie-mfbs/
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leet0"));

        int[] result = getNext(new int["aabaaf".length()], "aabaaf");
        PrintUtil.printIntArray(result);

        int[] function = function(new int["aabaaf".length()], "aabaaf");
        PrintUtil.printIntArray(function);
    }

    public static int strStr(String haystack, String needle) {
        return 0;
    }

    public static int[] getNext(int[] next, String string) {
        int j = 0;
        next[0] = j;
        char[] s = string.toCharArray();
        // 注意i从1开始
        for (int i = 1; i < s.length; i++) {
            // 前后缀不相同了 此处用 while 处理
            while (j > 0 && s[i] != s[j]) {
                // 向前回退
                j = next[j - 1];
            }
            // 找到相同的前后缀
            if (s[i] == s[j]) {
                j++;
            }
            // 将j（前缀的长度）赋给next[i]
            next[i] = j;
        }
        return next;
    }

    public static int[] function(int[] next, String s) {
        // 初始化
        int j = 0;
        next[0] = j;
        char[] chars = s.toCharArray();
        // for 循环
        for (int i = 1; i < chars.length; i++) {
            // 处理不相等的情况
            while (j > 0 && chars[i] != chars[j]) {
                j = next[j - 1];
            }
            // 处理相等的情况 j++
            if (chars[i] == chars[j]) {
                j++;
            }
            // 将自增的 j 赋值給 i 对应位置
            next[i] = j;
        }
        return next;
    }
}
