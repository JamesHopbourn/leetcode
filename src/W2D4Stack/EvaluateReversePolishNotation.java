package W2D4Stack;

import java.util.*;

/**
 * https://leetcode.cn/problems/evaluate-reverse-polish-notation/submissions/
 *
 * https://www.bilibili.com/video/BV1kd4y1o7on/
 * https://ls8sck0zrg.feishu.cn/wiki/JewPweUFPiGNG5kFr3ZcWmgHnkg
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2","1","+","3","*"}));
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }

    @SuppressWarnings("AlibabaSwitchStatement")
    public static int evalRPN(String[] tokens) {
        List<String> operation = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (!operation.contains(token)){
                 stack.add(token);
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int result = 0;
                switch (token){
                    case "+": result = num2 + num1; break;
                    case "-": result = num2 - num1; break;
                    case "*": result = num2 * num1; break;
                    case "/": result = num2 / num1; break;
                }
                stack.push(String.valueOf(result));
            }
        }
        return Integer.parseInt(stack.peek());
    }
}
