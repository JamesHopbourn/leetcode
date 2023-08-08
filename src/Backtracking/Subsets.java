package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1, 2, 3, 4}));
    }

    List<List<Integer>> result = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums);
        return result;
    }

    private void backtrack(int i, int[] nums) {
        result.add(new ArrayList<>(path));
        for (int j = i; j < nums.length; j++) {
            path.add(nums[j]);
            backtrack(j + 1, nums);
            path.remove(path.size() - 1);
        }
    }
}
