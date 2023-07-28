package W2D5Stack;

import common.PrintUtil;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/sliding-window-maximum/solution/by-ac_oier-o89l/
 * https://leetcode.cn/problems/sliding-window-maximum/solution/dan-diao-dui-lie-by-hang-3k-8sww/
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        PrintUtil.printIntArray(maxSlidingWindow(new int[]{1}, 1));
        PrintUtil.printIntArray(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i <= nums.length - k; i++) {
            int count = 0;
            while (count < k) {
                if (count == 0) {
                    stack.push(nums[i]);
                } else if (nums[i + count] > stack.peek()) {
                    stack.pop();
                    stack.push(nums[i + count]);
                }
                count++;
            }
            res[i] = stack.peek();
        }
        return res;
    }
}
