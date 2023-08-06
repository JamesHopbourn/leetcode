package W6D2DynamicProgramming;

public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(fib(2) == 1);
        System.out.println(fib(3) == 2);
        System.out.println(fib(4) == 3);
    }

    public static int fib(int n) {
        // 特殊情况处理
        if (n <= 1) {
            return n;
        }
        // 定义一个数组存储 dp 转移结果
        int[] dp = new int[n+1];
        // 初始化 dp
        dp[0] = 0;
        dp[1] = 1;
        // 遍历顺序
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        // 返回 dp 结果
        return dp[n];
    }
}
