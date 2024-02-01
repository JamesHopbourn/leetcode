package D1;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, nums) == 2);
    }

    public static int minSubArrayLen(int target, int[] nums){
        int sum = 0, left = 0, right = 0;
        int result = Integer.MAX_VALUE;
        for (;right < nums.length; right++) {
            sum += nums[right];
            // 当窗口内元素和大于等于目标值时，尝试缩小窗口
            while(sum >= target){
                // 计算当前窗口长度
                int len = right - left + 1;
                // 更新最短子数组长度
                result = Math.min(result, len);
                // 尝试缩小窗口，移动左指针，减去左边界的元素
                sum -= nums[left];
                // 左指针右移
                left++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}
