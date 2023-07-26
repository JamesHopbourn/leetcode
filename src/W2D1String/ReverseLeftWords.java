package W2D1String;

/**
 * https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 * https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/solution/mian-shi-ti-58-ii-zuo-xuan-zhuan-zi-fu-chuan-qie-p/
 */
public class ReverseLeftWords {
    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2));
        System.out.println(function("abcdefg", 2));
        System.out.println("cdefgab");
    }

    public static String function(String s, int n){
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = n; i < chars.length; i++) {
            builder.append(chars[i]);
        }
        for (int i = 0; i < n; i++) {
            builder.append(chars[i]);
        }
        return builder.toString();
    }

    public static String reverseLeftWords(String s, int n) {
        if (s.length() == 0) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            builder.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}
