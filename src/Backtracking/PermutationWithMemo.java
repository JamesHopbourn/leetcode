package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/permutations/submissions/">46. 全排列 - 力扣（LeetCode）</a> <p>
 * <a href="https://leetcode.cn/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/">回溯算法入门级详解 + 练习（持续更新） - 全排列 - 力扣（LeetCode）</a> <p>
 * <a href="https://labuladong.github.io/algo/di-san-zha-24031/bao-li-sou-96f79/hui-su-sua-c26da/">回溯算法解题套路框架 | labuladong 的算法小抄</a> <p>
 */
public class PermutationWithMemo {
    public static void main(String[] args) {
        new PermutationWithMemo().permute(new int[]{1, 2, 3}).forEach(System.out::println);
    }

    List<List<Integer>> result = new ArrayList<>();

    List<List<Integer>> permute(int[] nums) {
        // 使用 LinkedList<Integer> 而不是 List<Integer>
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backtracking(nums, track, used);
        return result;
    }

    void backtracking(int[] nums, LinkedList<Integer> track, boolean[] used) {
        if (track.size() == nums.length) {
            // 注意这里要 new LinkedList<>(track) 而不能直接 add(track)
            result.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]){
                continue;
            }
            // 选中元素
            used[i] = true;
            track.add(nums[i]);
            // 回溯
            backtracking(nums, track, used);
            // 回溯弹出
            track.removeLast();
            used[i]= false;
        }
    }
}
