package W6D2;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        minCostClimbingStairs(new int[]{10, 15, 20});

    }

    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        // 想清楚为什么是 0 1 而不是 1 2
        // 因为 cost 数组消耗的体力就是从 0 开始的
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
}
