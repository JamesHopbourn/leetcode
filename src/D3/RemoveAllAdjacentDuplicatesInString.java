package D3;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }

    public static String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if (!stack.isEmpty() && stack.peek() == aChar){
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }
        StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty()){
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }

}
