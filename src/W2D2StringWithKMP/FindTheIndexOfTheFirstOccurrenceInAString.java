package W2D2StringWithKMP;

import common.PrintUtil;

/**
 * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string
 * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/solution/shua-chuan-lc-shuang-bai-po-su-jie-fa-km-tb86/
 * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/solution/dai-ma-sui-xiang-lu-kmpsuan-fa-xiang-jie-mfbs/
 * https://programmercarl.com/0028.%E5%AE%9E%E7%8E%B0strStr.html#%E5%85%B6%E4%BB%96%E8%AF%AD%E8%A8%80%E7%89%88%E6%9C%AC
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
        if (needle.length() == 0) {
            return 0;
        }

        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            // 注意这里是 needle.charAt(j) != haystack.charAt(i)
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) {
                // 回溯
                j = next[j - 1];
            }
            // 注意这里是 needle.charAt(j) == haystack.charAt(i)
            if (needle.charAt(j) == haystack.charAt(i)) {
                // 增加
                j++;
            }
            if (j == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return -1;
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

    /**
     * 3,1,3
     *
     * @param next
     * @param s
     * @return
     */
    public static int[] func(int[] next, String s) {
        int j = 0;
        next[0] = j;
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            // j 回溯
            while (j > 0 && next[i] != next[j]) {
                j = next[j - 1];
            }
            // if 判断相等
            if (next[i] == next[j]) {
                j++;
            }
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
