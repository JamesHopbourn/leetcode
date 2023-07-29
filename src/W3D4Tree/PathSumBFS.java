package W3D4Tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/path-sum/">112. 路径总和 - 力扣（LeetCode）</a>
 * <a href="https://leetcode.cn/problems/path-sum/solution/lu-jing-zong-he-by-leetcode-solution/">路径总和</a>
 */
public class PathSumBFS {

    public static void main(String[] args) {
        System.out.println(hasPathSum(TreeNode.createTree(new Integer[]{1, 2, 3}), 5));
        System.out.println(hasPathSum(TreeNode.createTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1}), 22));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        Queue<Integer> sumQueue = new LinkedList<>();
        sumQueue.add(root.val);
        // 节点循环的同时也在循环比较节点值
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            Integer val = sumQueue.poll();
            // 如果这个节点是一个叶子节点，就判断是否相等
            if (node.left == null && node.right == null) {
                if (val == targetSum) {
                    return true;
                }
                continue;
            }
            if (node.left != null) {
                nodeQueue.add(node.left);
                sumQueue.add(val + node.left.val);
            }
            if (node.right != null) {
                nodeQueue.add(node.right);
                sumQueue.add(val + node.right.val);
            }
        }
        return false;
    }
}
