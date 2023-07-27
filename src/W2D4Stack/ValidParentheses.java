package W2D4Stack;

import java.util.Stack;

/**
 * https://www.bilibili.com/video/BV1AF411w78g/
 * 
 * https://leetcode.cn/problems/valid-parentheses/
 * https://leetcode.cn/problems/valid-parentheses/solution/valid-parentheses-fu-zhu-zhan-fa-by-jin407891080/
 *
 * https://ls8sck0zrg.feishu.cn/wiki/JewPweUFPiGNG5kFr3ZcWmgHnkg
 */
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
