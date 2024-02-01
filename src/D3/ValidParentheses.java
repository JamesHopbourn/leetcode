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
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if (aChar == '{') {
                stack.push('}');
            } else if (aChar == '(') {
                stack.push(')');
            } else if (aChar == '[') {
                stack.push(']');
            } else {
                if (stack.isEmpty() || stack.peek() != aChar) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

}
