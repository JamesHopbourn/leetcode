package D3;

import java.util.PriorityQueue;

public class MaxHeapDemo {

    public static void main(String[] args) {
        // 创建大顶堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // 插入一组数字
        int[] numbers = {4, 10, 8, 5, 1, 7};
        for (int num : numbers) {
            maxHeap.offer(num);
        }

        // 获取最大值（堆顶元素）
        System.out.println("当前堆顶最大值：" + maxHeap.peek());

        // 插入新元素
        int newNumber = 12;
        maxHeap.offer(newNumber);

        // 再次获取最大值
        System.out.println("插入新元素后堆顶最大值：" + maxHeap.peek());
    }
}
