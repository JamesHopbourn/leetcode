package W4D4Backtracking;

import java.util.*;

/**
 * <a href="https://www.bilibili.com/video/BV1c54y1e7k6/">带你学透回溯算法-分割回文串（对应力扣题目：131.分割回文串）| 回溯法精讲！_哔哩哔哩_bilibili</a>
 * <a href="https://programmercarl.com/0131.%E5%88%86%E5%89%B2%E5%9B%9E%E6%96%87%E4%B8%B2.html#%E6%80%9D%E8%B7%AF">代码随想录 131.分割回文串</a>
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        List<List<String>> aab = new PalindromePartitioning().partition("aab");
        for (List<String> list : aab) {
            System.out.println(Arrays.toString(new List[]{list}));
        }
    }

    List<List<String>> result = new ArrayList<>();
    List<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return result;
    }

    public void backtracking(String s, int startIndex) {
        // 如果分割线位置大等于 s 长度收集结果
        // 为什么不做回文串判断，因为下面的 continue 处理了不是回文串的情况
        if (startIndex >= s.length()) {
            result.add(new ArrayList(path));
            return;
        }
        // 逐位切割并判断合法性
        for (int i = startIndex; i < s.length(); i++) {
            // 如何想清楚此处 startIndex 和 i 的位置关系
            // startIndex 是起始位置，i 会随着 for 循环逐渐增加
            if (isPalindrome(s, startIndex, i)) {
                // 为什么此处是 +1，因为要判断接下来一位是否能够判断回文
                String substring = s.substring(startIndex, i + 1);
                path.add(substring);
            } else {
                continue;
            }
            // 回溯
            backtracking(s, i + 1);
            // 删除
            path.remove(path.size()-1);
        }
    }

    private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
