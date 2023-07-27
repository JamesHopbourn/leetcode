package W2D4Stack;

import java.util.Stack;

/**
 * https://www.bilibili.com/video/BV12a411P7mw/
 * https://programmercarl.com/1047.%E5%88%A0%E9%99%A4%E5%AD%97%E7%AC%A6%E4%B8%B2%E4%B8%AD%E7%9A%84%E6%89%80%E6%9C%89%E7%9B%B8%E9%82%BB%E9%87%8D%E5%A4%8D%E9%A1%B9.html
 *
 * https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/
 * https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/solution/shan-chu-zi-fu-chuan-zhong-de-suo-you-xi-4ohr/
 *
 * https://ls8sck0zrg.feishu.cn/wiki/JewPweUFPiGNG5kFr3ZcWmgHnkg
 */
public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }

    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (!stack.isEmpty() && stack.peek() == aChar){
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }
        StringBuilder build = new StringBuilder();
        while(!stack.isEmpty()){
            build.insert(0, stack.pop());
        }
        return build.toString();
    }
}
