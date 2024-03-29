package D2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[0] > 0){
                return result;
            }
            // 去重a，注意是从后往前去看
            if (i > 1 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0){
                    left++;
                } else if (sum > 0){
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    // -1 0 0 0 0 1 1 1 1
                    while (right > left && nums[right] == nums[right-1]) {
                        right--;
                    }
                    while (right > left && nums[left] == nums[left+1]) {
                        left++;
                    }
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}
