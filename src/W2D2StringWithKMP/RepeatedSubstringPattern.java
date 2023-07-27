package W2D2StringWithKMP;

/**
 * https://leetcode.cn/problems/repeated-substring-pattern/
 * https://ls8sck0zrg.feishu.cn/wiki/P3vYw8nB9i2In3kS3lNcFXBvnme
 */
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abcabc"));
        System.out.println(repeatedSubstringPattern("ababab"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        String s1 = s + s;
        String substring = s1.substring(1, s1.length() - 1);
        return substring.contains(s);
    }
}
