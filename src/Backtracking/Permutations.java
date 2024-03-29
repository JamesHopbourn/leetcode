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
        System.out.println(-1 & -10);
        new Permutations().permute(new int[]{1, 2, 3}).forEach(System.out::println);
    }

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtracking(nums, track);
        return result;
    }

    public void backtracking(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length){
            result.add(new ArrayList<>(track));
            return;
        }
        for (int num : nums) {
            if (track.contains(num)) {
                continue;
            }
            track.add(num);
            backtracking(nums, track);
            track.removeLast();
        }
    }
}
