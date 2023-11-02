package D3;

import java.util.Stack;

/**
 * https://ls8sck0zrg.feishu.cn/wiki/C7kpwXv20iHShwkeBTycevGPnGe <p>
 *
 * https://leetcode.cn/problems/implement-queue-using-stacks/
 */
public class ImplementQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        int param_2 = obj.pop();
        System.out.println("param_2 = " + param_2);
        int param_3 = obj.peek();
        System.out.println("param_3 = " + param_3);
        boolean queueIsEmpty = obj.empty();
        System.out.println("param_4 = " + queueIsEmpty);
    }

    static class MyQueue {
        private final Stack<Integer> inStack;
        private final Stack<Integer> outStack;

        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop(){
            inStackMoveOutStack();
            Integer pop = outStack.pop();
            return pop;
        }

        private void inStackMoveOutStack() {
            if (outStack.isEmpty()){
                while (!inStack.isEmpty()){
                     outStack.push(inStack.pop());
                }
            }
        }

        public int peek() {
            inStackMoveOutStack();
            Integer pop = outStack.pop();
            outStack.push(pop);
            return pop;
        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }
    }
}
