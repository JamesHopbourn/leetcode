package W6D4DymanicProgramming;

public class Bag {
    public static void main(String[] args) {
        int[] weight = {2, 3, 4};
        int[] value = {3, 4, 5};
        int bagWeight = 5;

        int[] dp = new int[bagWeight + 1];
                                            
        for (int i = 0; i < weight.length; i++) { // 遍历物品
            for (int j = bagWeight; j >= weight[i]; j--) { // 正确的遍历背包容量，从大到小
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }


        System.out.println("Maximum value in the knapsack: " + dp[bagWeight]);
    }
}
