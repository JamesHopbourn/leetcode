package W2D4;

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
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char aChar : s.toCharArray()) {
            if (aChar == '{') {
                stack.push('}');
            } else if (aChar == '(') {
                stack.push(')');
            } else if (aChar == '[') {
                stack.push(']');
            } else {
                if (stack.isEmpty() || aChar != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
