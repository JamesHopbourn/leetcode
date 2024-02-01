package D2;

public class ReverseStringII {
    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
    }

    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2*k) {
            int start = i;
            int end = Math.min(chars.length-1, i+k-1);
            while (start < end){
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }

        }
        return new String(chars);
    }
}
