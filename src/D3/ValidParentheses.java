package D3;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("["));
        System.out.println(isValid("[]"));
        System.out.println(isValid("{}"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("{[}]"));
    }

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        if (chars.length % 2 == 1) {
            return false;
        }
        Stack<Character> strings = new Stack<>();
        for (char aChar : s.toCharArray()) {
            if (aChar == '{') {
                strings.push('}');
            } else if (aChar == '[') {
                strings.push(']');
            } else if (aChar == '(') {
                strings.push(')');
            } else {
                if (strings.isEmpty() || strings.pop() != aChar) {
                    return false;
                } else {
                    strings.pop();
                }
            }
        }
        return strings.isEmpty();
    }

}
