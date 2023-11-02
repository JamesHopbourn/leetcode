package D3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2","1","+","3","*"}));
    }

    public static int evalRPN(String[] tokens) {
        List<String> operation = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (!operation.contains(token)){
                stack.add(token);
            } else {
                Integer num1 = Integer.parseInt(stack.pop());
                Integer num2 = Integer.parseInt(stack.pop());
                int result = 0;
                switch (token){
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                }
                stack.push(String.valueOf(result));
            }
        }
        return Integer.parseInt(stack.peek());
    }

}
