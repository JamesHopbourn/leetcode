package D2;

import common.PrintUtil;

public class ReverseString {
    public static void main(String[] args) {
        char[] chars = reverseString(new char[]{'J', 'a', 'm', 'e', 's'});
        PrintUtil.printCharArray(chars);

    }

    public static char[] reverseString(char[] s) {
        int l  =0 ;
        int r = s.length - 1;
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
