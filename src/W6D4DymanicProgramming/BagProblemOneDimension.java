package W6D4DymanicProgramming;

public class BagProblemOneDimension {
    public static void main(String[] args) {
        // 有三个物品，定义他们的重量和价值
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        // 背包的容量为 4
        int bagSize = 4;
        function(weight, value, bagSize);
    }

    public static void function(int[] weight, int[] value, int bagSize) {
        // 为什么此处初始化要加一，因为要额外考虑一下 bagSize = 0 的情况
        int[] dp = new int[bagSize + 1];

        dp[0] = 0;

//        for (int i = 0; i < weight.length; i++) {
//            for (int j = weight[i]; j <= bagSize; j++) {
//                dp[i] = Math.max(dp[i], dp[j - weight[i]] + value[i]);
////                System.out.println(dp[j - weight[i]] + value[i]);
//            }
//        }

        for (int i = 0; i < weight.length; i++) {
             for (int j = bagSize; j >= weight[i];j--){
                 dp[i] = Math.max(dp[i], dp[j - weight[i]] + value[i]);
             }
        }

        for (int i = 0; i <= bagSize; i++) {
            System.out.println(dp[i]);
        }
    }
}
