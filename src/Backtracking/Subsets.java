package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1, 2, 3, 4}));
    }

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(0, nums);
        return result;
    }

    public void backtracking(int i, int[] nums) {
        // 因为是求子集，没有元素个数的要求，在任何一次回溯过程中都要收集
        result.add(new ArrayList<>(path));
        for (int j = i; j < nums.length; j++) {
            path.add(nums[j]);
            backtracking(j + 1, nums);
            path.removeLast();
        }
    }
}
