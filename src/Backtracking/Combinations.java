package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        System.out.println(new Combinations().combine(3, 2));
    }

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    List<List<Integer>> combine(int n, int k) {
        backtracking(1, n, k);
        return result;
    }

    void backtracking(int startIndex, int n, int k) {
        // 终止条件
        if (path.size() == k) {
            // 存放结果
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backtracking(i+1, n, k);
            path.removeLast();
        }
    }
}
