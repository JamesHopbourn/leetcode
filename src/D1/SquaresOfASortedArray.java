package D1;

import java.util.Arrays;

/**
 * <a href="https://www.bilibili.com/video/BV1QB4y1D7ep/">双指针法经典题目 | LeetCode：977.有序数组的平方_哔哩哔哩_bilibili</a>
 * <a href="https://leetcode.cn/problems/squares-of-a-sorted-array/description/">977. 有序数组的平方 - 力扣（LeetCode）</a>
 */

public class SquaresOfASortedArray {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int k = nums.length - 1;
        for (int i = 0, j = nums.length - 1; i <= j; ) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                result[k--] = nums[i] * nums[i];
                i++;
            } else {
                result[k--] = nums[j] * nums[j];
                j--;
            }
        }
        return result;
    }
}
