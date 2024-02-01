package D3;

import java.util.PriorityQueue;

public class MinHeapDemo {

    public static void main(String[] args) {
        // 创建小顶堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 插入一组数字
        int[] numbers = {4, 10, 8, 5, 1, 7};
        for (int num : numbers) {
            minHeap.offer(num);
        }

        // 获取最小值（堆顶元素）
        System.out.println("当前堆顶最小值：" + minHeap.peek());

        // 插入新元素
        int newNumber = 3;
        minHeap.offer(newNumber);

        // 再次获取最小值
        System.out.println("插入新元素后堆顶最小值：" + minHeap.peek());
    }
}