package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/permutations/submissions/">46. 全排列 - 力扣（LeetCode）</a>
 * <a href="https://leetcode.cn/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/">回溯算法入门级详解 + 练习（持续更新） - 全排列 - 力扣（LeetCode）</a>
 * <a href="https://labuladong.github.io/algo/di-san-zha-24031/bao-li-sou-96f79/hui-su-sua-c26da/">回溯算法解题套路框架 | labuladong 的算法小抄</a>
 */
public class Permutations {
    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        System.out.println(permutations.permute(new int[]{1, 2, 3, 4}));
    }

    List<List<Integer>> res = new ArrayList<>();

    List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> result =  new LinkedList<>();
        backtracking(nums, result);
        return res;
    }

    void backtracking(int[] nums, LinkedList<Integer> result){
        if (result.size() == nums.length){
            res.add(new LinkedList<>(result));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (result.contains(nums[i])){
                continue;
            }
            result.add(nums[i]);
            backtracking(nums, result);
            result.removeLast();
        }
    }
}
