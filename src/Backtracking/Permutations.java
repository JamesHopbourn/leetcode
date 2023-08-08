package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/permutations/submissions/">46. 全排列 - 力扣（LeetCode）</a> <p>
 * <a href="https://leetcode.cn/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/">回溯算法入门级详解 + 练习（持续更新） - 全排列 - 力扣（LeetCode）</a> <p>
 * <a href="https://labuladong.github.io/algo/di-san-zha-24031/bao-li-sou-96f79/hui-su-sua-c26da/">回溯算法解题套路框架 | labuladong 的算法小抄</a> <p>
 */
public class Permutations {
    public static void main(String[] args) {
        new Permutations().permute(new int[]{1, 2, 3}).forEach(System.out::println);
    }

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();

    List<List<Integer>> permute(int[] nums) {
        backtracking(nums, track);
        return result;
    }

    void backtracking(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            // 注意这里要 new LinkedList<>(track) 而不能直接 add(track)
            result.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtracking(nums, track);
            track.removeLast();
        }
    }
}
