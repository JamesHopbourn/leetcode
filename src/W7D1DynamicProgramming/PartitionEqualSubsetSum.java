package W7D1DynamicProgramming;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
    }

    public static boolean canPartition(int[] nums) {
        // 非空检查
        if (nums.length == 0){
            return false;
        }
        // 数量检查
        if (nums.length % 2 == 1){
            return false;
        }
        // 求平均值
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum/2;
        // 定义 dp 数组
        int[] dp = new int[target + 1];

        for(int i = 0; i < nums.length; i++) {
            for(int j = target; j >= nums[i]; j--) {
                //物品 i 的重量是 nums[i]，其价值也是 nums[i]
                
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        return dp[target] == target;
    }

}
