package W3D1Tree;

import common.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/invert-binary-tree/">226. 翻转二叉树 - 力扣（LeetCode）</a>
 */
public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        TreeNode.show(invertTree(tree));
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
