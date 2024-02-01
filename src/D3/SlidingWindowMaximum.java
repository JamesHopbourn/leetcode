package D3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] ints = {1, 3, -1, -3, 5, 3, 6, 7};
        List<Integer> result = maxSlidingWindow(ints, 3);
        System.out.println("result = " + result);
    }

    public static List<Integer> maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || k <= 0 || nums.length < k){
            return result;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]){
                queue.removeLast();
            }
            queue.add(i);
            if (queue.getFirst() <= i-k){
                queue.removeFirst();
            }
            if(i >= k-1){
                result.add(nums[queue.getFirst()]);
            }
        }
        return result;
    }
}
