package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1, 2, 3, 4}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> track) {
        res.add(new ArrayList<>(track));
        for (int j = i; j < nums.length; j++) {
            track.add(nums[j]);
            backtrack(j + 1, nums, res, track);
            track.remove(track.size() - 1);
        }
    }
}
