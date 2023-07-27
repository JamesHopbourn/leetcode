package W2D3QueueStacks;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/implement-stack-using-queues/ <p>
 * https://www.bilibili.com/video/BV1nY4y1w7VC/ <p>
 * <p>
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1265121791832960 <p>
 * https://leetcode.cn/problems/implement-stack-using-queues/solution/yong-dui-lie-shi-xian-zhan-by-leetcode-solution/ <p>
 */
public class ImplementStackUsingQueues {
    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        int param_2 = obj.pop();
        System.out.println("param_2 = " + param_2);
        int param_3 = obj.top();
        System.out.println("param_3 = " + param_3);
        boolean param_4 = obj.empty();
        System.out.println("param_4 = " + param_4);
    }

    static class MyStack {
        Queue<Integer> queue;

        public MyStack() {
            // 注意这里的类型是 LinkedList
            queue = new LinkedList<Integer>();
        }

        public void push(int x) {
            // 注意这里保存的是 size，而不是 size-1
            int size = queue.size();
            queue.offer(x);
            for (int i = 0; i < size; i++) {
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
