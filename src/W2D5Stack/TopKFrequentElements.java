package W2D5Stack;

import common.PrintUtil;

import java.util.*;

/**
 * https://www.bilibili.com/video/BV1Xg41167Lz/ <p>
 * https://leetcode.cn/problems/top-k-frequent-elements/ <p>
 * https://leetcode.cn/problems/top-k-frequent-elements/solution/qian-k-ge-gao-pin-yuan-su-by-leetcode-solution/ <p>
 *
 *  <a href="https://www.bilibili.com/video/BV1Xg41167Lz/">Google</a> <p>
 *
 * https://programmercarl.com/0347.%E5%89%8DK%E4%B8%AA%E9%AB%98%E9%A2%91%E5%85%83%E7%B4%A0.html <p>
 * https://ls8sck0zrg.feishu.cn/wiki/CukjwBATyi54Zvk4SEzcTKVgntg <p>
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        PrintUtil.printIntArray(function(new int[]{1}, 1));
        PrintUtil.printIntArray(topKFrequent(new int[]{1}, 1));

        PrintUtil.printIntArray(function(new int[]{1, 1, 1, 2, 2, 3}, 2));
        PrintUtil.printIntArray(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }

    public static int[] function(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();
            // 如果达到 k 个了做比较
            if (queue.size() == k) {
                // 取 queue.peek()[1] 即频率 count
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{key, count});
                }
            } else {
                // 否则直接添加到队列中
                queue.offer(new int[]{key, count});
            }
        }

        // 转为数组的形式返回
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll()[0];
        }
        return result;
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll()[0];
        }
        return result;
    }
}
