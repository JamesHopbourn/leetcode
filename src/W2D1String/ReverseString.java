package W2D1String;

/**
 * https://leetcode.cn/problems/reverse-string/
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] chars = reverseString(new char[]{'J', 'a', 'm', 'e', 's'});
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + " ");
        }
    }

    public static char[] reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1 ;
        while (l < r){
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
        return s;
    }
}
