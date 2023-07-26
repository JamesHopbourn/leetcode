package W2D1String;

/**
 * https://leetcode.cn/problems/reverse-string-ii/
 * https://leetcode.cn/problems/reverse-string-ii/solution/shuang-zhi-zhen-541-fan-zhuan-zi-fu-chua-3vjk/
 */
public class ReverseStringII {
    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
        System.out.println(function("abcdefg", 2));
    }

    public static String function(String s, int k){
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i+=2*k) {
            int l = i;
            int r = Math.min(s.length(), i-1+k);
            while (l < r){
                char temp = chars[l];
                chars[l] = chars[r];
                chars[r] = temp;
                l++;
                r--;
            }
        }
        return new String(chars);
    }
    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            int start = i;
            int end = Math.min(s.length() - 1, i + k - 1);
            while (start < end) {
                char temp;
                temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
        }
        return new String(chars);
    }
}
