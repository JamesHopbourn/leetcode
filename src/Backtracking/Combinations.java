package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    public static void backtracking(int n, int k, int startIndex) {
        // 终止条件
        if (path.size() == k) {
            // 存放结果
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            // 处理节点
            path.add(i);
            // 递归
            backtracking(n, k, i + 1);
            // 回溯
            path.removeLast();
        }
    }
}
