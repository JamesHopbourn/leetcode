package D3;

import common.PrintUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static void main(String[] args) {
        PrintUtil.printIntArray(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));

    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (queue.size() == k){
                if (queue.peek()[1] < count){
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
