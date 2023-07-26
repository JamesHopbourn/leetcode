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

        System.out.println();
        
        char[] result = function(new char[]{'J', 'a', 'm', 'e', 's'});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static char[] function(char[] chars){
        int l = 0;
        int r = chars.length - 1;
        while (l < r){
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
        return chars;
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
