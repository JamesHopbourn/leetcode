package W3D2Tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 算法小抄 P55
 * <a href="https://leetcode.cn/problems/minimum-depth-of-binary-tree/submissions/">111. 二叉树的最小深度 - 力扣（LeetCode）</a>
 */
public class MinimumDepthOfBinaryTreeBFS {
    public static void main(String[] args) {
        System.out.println(minDepth(TreeNode.createTree(new Integer[]{3, 9, 20, null, null, 15, 7})) == 2);
        System.out.println(minDepth(TreeNode.createTree(new Integer[]{2, null, 3, null, 4, null, 5, null, 6})));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0){
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null){
                    return level;
                }
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            level++;
        }
        return level;
    }
}
