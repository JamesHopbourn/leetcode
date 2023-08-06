package W6D3DynamicProgramming;

/**
 * <a href="https://leetcode.cn/problems/unique-paths/description/">62. 不同路径 - 力扣（LeetCode）</a>
 * <a href="https://www.bilibili.com/video/BV1ve4y1x7Eu/">动态规划中如何初始化很重要！| LeetCode：62.不同路径</a>
 * <a href="https://programmercarl.com/0062.%E4%B8%8D%E5%90%8C%E8%B7%AF%E5%BE%84.html#%E6%80%BB%E7%BB%93">62.不同路径</a>
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(2, 4));
        System.out.println(uniquePaths(3, 2));
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 竖向全部初始化为 1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        // 横向全部初始化为 1
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        // 遍历
        // 为什么是从 m 和 n 从 1 开始？
        // 因为要先前走一步才能开始计算
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 注意这里不是 dp[i-1][0]，坐标在这里不可能写死
                // 这里本质上就是计算左边和上面的和給当前的格子
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        // 打印 dp 数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        // 为什么此处 m 和 n 要减去 1？
        // 因为数组下标从 0 开始，和人的理解不一样
        return dp[m - 1][n - 1];
    }
}
