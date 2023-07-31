package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://programmercarl.com/0039.%E7%BB%84%E5%90%88%E6%80%BB%E5%92%8C.html#%E5%85%B6%E4%BB%96%E8%AF%AD%E8%A8%80%E7%89%88%E6%9C%AC">代码随想录 39. 组合总和</a> <p>
 * <a href="https://www.bilibili.com/video/BV1KT4y1M7HJ/">带你学透回溯算法-组合总和（对应「leetcode」力扣题目：39.组合总和）| 回溯法精讲！_哔哩哔哩_bilibili</a> <p>
 * <a href="https://leetcode.cn/problems/combination-sum/">39. 组合总和 - 力扣（LeetCode）</a> <p>
 */
public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 1. 先进行排序
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return result;
    }

    private void backtracking(int[] candidates, int target, int sum, int index) {
        if (sum == target){
            // 2. 此处要使用 new ArrayList<>(path) 不能直接 add(path)
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > target){
                // 3. 此处使用 break 而不是 return，要继续下一轮
                break;
            }
            path.add(candidates[i]);
            // 4. 注意最后的的起始索引是 i 而不是 index，否则就死循环了
            backtracking(candidates, target, sum + candidates[i], i);
            // 5. 此处回溯移除元素要使用 path.size() - 1，不能使用 remove(candidates[i])
            path.remove(path.size() - 1);
        }
    }
}
