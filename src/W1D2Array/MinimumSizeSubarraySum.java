package W1D2Array;


import static java.lang.Math.min;

/**
 * https://www.bilibili.com/video/BV17t4y1W7JP
 * https://www.bilibili.com/video/BV1tZ4y1q7XE
 * https://ls8sck0zrg.feishu.cn/wiki/NxThweD48iXGmdk90oTcK7UInmc
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] ints = {2, 3, 1, 2, 4, 3};
        int function = function(ints, 7);
        System.out.println(function);
    }

    public static int function(int[] nums, int target){
        int res = 0;
        int sum = 0;
        int left = 0;
        int right = 0;
        for (right = 0; right < nums.length; right++){
            sum += nums[right];
            while (sum >= target){
                int len = right - left + 1;
                res = res == 0 ? len : min(res, len);
                sum -= nums[left];
                // 缩小
                left++;
            }
        }
        return res;
    }
}
