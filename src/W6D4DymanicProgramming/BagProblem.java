package W6D4DymanicProgramming;

/**
 * <a href="https://www.bilibili.com/video/BV1cg411g7Y6/">带你学透0-1背包问题！| 关于背包问题，你不清楚的地方，这里都讲了！| 动态规划经典问题 | 数据结构与算法_哔哩哔哩_bilibili</a> <p>
 * <a href="https://programmercarl.com/%E8%83%8C%E5%8C%85%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%8001%E8%83%8C%E5%8C%85-1.html#%E6%80%9D%E8%B7%AF">代码随想录 动态规划：01背包理论基础</a>
 */
public class BagProblem {
    public static void main(String[] args) {
        // 有三个物品，定义他们的重量和价值
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        // 背包的容量为 4
        int bagSize = 4;
        function(weight, value, bagSize);
    }

    public static void function(int[] weight, int[] value, int bagSize) {
        // 定义 dp 数组，此处初始化的时候需要对 bagSize 进行 +1，因为 bagSize 要额外增加一个 bagSize = 0 的情况
        int[][] dp = new int[weight.length][bagSize + 1];

        // 寻找第一个 i = weight[0] 的位置，并从此往后都赋值为第一个物品的 value，即 value[0]
        // 注意此处之所以需要使用 <= 是因为上面初始化的时候 bagSize 是 +1 的，如果不使用 <= 最后一个位置是没有赋值的
        for (int i = weight[0]; i <= bagSize; i++) {
            dp[0][i] = value[0];
        }

        // 由于第一列和第一行已经初始化了，第一列是隐式初始化，默认创建数组里面的值就是 0
        // 初始化完成之后，就不需要再操作了，所以行和列都是从 1 开始计算 dp 方程
        // 此处 weight.length 和 bagSize 分别用的是 < 和 <= 上面已经做过解释
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= bagSize; j++) {
                // 判断如果背包容量 j 小于物品的重量，说明背包装不下了，就舍弃使用上一个值
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 如果背包装得下，判断装了收益大还是不装收益大，取收益最大值赋值给 dp[i][j]
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        // 遍历打印整个 dp 二维数组，bagSize 还是使用 <=，因为初始化的时候被 +1 了
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println(dp[weight.length-1][bagSize]);
    }

    /**
     * 动态规划获得结果
     * @param weight  物品的重量
     * @param value   物品的价值
     * @param bagSize 背包的容量
     */
    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize){

        // 创建dp数组
        int goods = weight.length;  // 获取物品的数量
        int[][] dp = new int[goods][bagSize + 1];

        // 初始化dp数组
        // 创建数组后，其中默认的值就是0
        for (int j = weight[0]; j <= bagSize; j++) {
            dp[0][j] = value[0];
        }

        // 填充dp数组
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i]) {
                    /**
                     * 当前背包的容量都没有当前物品i大的时候，是不放物品i的
                     * 那么前i-1个物品能放下的最大价值就是当前情况的最大价值
                     */
                    dp[i][j] = dp[i-1][j];
                } else {
                    /**
                     * 当前背包的容量可以放下物品i
                     * 那么此时分两种情况：
                     *    1、不放物品i
                     *    2、放物品i
                     * 比较这两种情况下，哪种背包中物品的最大价值最大
                     */
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j-weight[i]] + value[i]);
                }
            }
        }

        // 打印dp数组
        for (int i = 0; i < goods; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }
}