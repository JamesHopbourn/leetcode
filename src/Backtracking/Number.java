package Backtracking;

public class Number {
    public static void main(String[] args) {
        System.out.println("monotoneIncreasingDigits(332) = " + monotoneIncreasingDigits(332));
    }

    public static int monotoneIncreasingDigits(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int flag = chars.length;
        for (int i = chars.length - 2; i >= 0; i--){
            if (chars[i] > chars[i+1]){
                chars[i]--;
                flag = i + 1;
            }
        }
        for (int i = flag; i < chars.length; i++){
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}
