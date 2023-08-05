package W6D2;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(2) == 2);
        System.out.println(climbStairs(3) == 3);
    }

    public static int climbStairs(int n) {
        // 特殊情况处理
        if (n<=2) {
            return n;
        }
        // 定义一个数组存储 dp 转移结果
        int[] dp = new int[n+1];
        // 初始化 dp
        dp[1] = 1;
        dp[2] = 2;
        // 遍历顺序
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        // 返回 dp 结果
        return dp[n];
    }
}
