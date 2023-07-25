package W1D5Hash;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://www.bilibili.com/video/BV1aT41177mK/
 * https://leetcode.cn/problems/two-sum/
 * https://ls8sck0zrg.feishu.cn/wiki/JecHwoz2uiZRlmktZ2ecW1DYnQ7
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(forLoop(new int[]{2, 7, 11, 15}, 9)));

        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 获取补数
            int diff = target - nums[i];
            boolean b1 = map.containsKey(diff);
            if (b1){
                 return new int[]{map.get(diff), i};
            }
            // 如果找不到对应的补数，先将数字加入 HashMap
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static int[] twoSumSimple(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 获取补数
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            // 如果找不到对应的补数，先将数字加入 HashMap
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static int[] forLoop(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[]{j, i};
                }
            }
        }
        return new int[]{};
    }
}
