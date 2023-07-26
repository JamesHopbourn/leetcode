package W1D6Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/3sum/
 * https://www.bilibili.com/video/BV1GW4y127qo/
 * https://programmercarl.com/0015.%E4%B8%89%E6%95%B0%E4%B9%8B%E5%92%8C.html
 * https://leetcode.cn/problems/3sum/solution/san-shu-zhi-he-by-leetcode-solution/
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(Arrays.asList(result));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        /*
        1,1,1,1,3
        1,1,3
        */
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 经过排序后，如果 num[i] 起始位置都大于 0 了，说明不存在任何结果相加等于 0，直接 return
            if (nums[i] > 0) {
                return result;
            }
            // 跳过相同的元素以避免重复，前面已经收集一次了，例如 0(get) -1(get) -1(continue) 1 1(get)
            // 如果不加 i > 0，那么在 i = 0 的时候会越界
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 定义双指针开始移动
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 找到一个三元组之后，对临近的 B C 去重 例如：-3 -1 -1 -1 4 4 4
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    // 移动 left、right 指针位置准备开始下一轮 while 循环
                    left++;
                    right--;
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> function(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }
            // 前面收集过了，跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 定义双指针开始 while 循环
            // 每次新进入一次循环都重新赋值一次 实现了指针的移动
            int left = i + 1;
            int right = nums.length - 1;
            // 此处不能使用 <= 如果是使用了 = 会把三数之和变成了「两数之和」
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}
