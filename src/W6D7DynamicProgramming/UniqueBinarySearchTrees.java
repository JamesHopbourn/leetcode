package W6D7DynamicProgramming;

/**
 * <a href="https://programmercarl.com/0096.%E4%B8%8D%E5%90%8C%E7%9A%84%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91.html">代码随想录</a>
 * <a href="https://leetcode.cn/problems/unique-binary-search-trees/">96. 不同的二叉搜索树 - 力扣（LeetCode）</a>
 * <a href="https://www.bilibili.com/video/BV1eK411o7QA/">动态规划找到子状态之间的关系很重要！| LeetCode：96.不同的二叉搜索树_哔哩哔哩_bilibili</a>
 */
public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        System.out.println(numTrees(3) == 5);
    }

    public static int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // 此处的易错点是此处需要使用 += 和 *
                // += 计算一共有多种组合，* 计算左右树的组合情况
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
