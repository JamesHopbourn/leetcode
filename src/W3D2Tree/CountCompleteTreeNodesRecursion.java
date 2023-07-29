package W3D2Tree;

import common.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/count-complete-tree-nodes/">222. 完全二叉树的节点个数 - 力扣（LeetCode）</a>
 * <a href="https://leetcode.cn/problems/count-complete-tree-nodes/solution/dsd-yong-wan-quan-er-cha-shu-ding-yi-qiu-le2l/">【DSD】用完全二叉树定义求完全二叉树结点数</a>
 */
public class CountCompleteTreeNodesRecursion {
    public static void main(String[] args) {
        // 题目已经明确说给的都是完全二叉树
        System.out.println(countNodes(new TreeNode()));
        System.out.println(countNodes(TreeNode.createTree(1)));
        System.out.println(countNodes(TreeNode.createTree(2)));
        System.out.println(countNodes(TreeNode.createTree(3)));
        System.out.println(countNodes(TreeNode.createTree(4)));
        System.out.println(countNodes(TreeNode.createTree(5)));
    }

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDeepth = 0;
        int rightDeepth = 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 一直找下去找到最左边的节点
        while (left != null) {
            left = left.left;
            leftDeepth++;
        }
        // 一直找下去找到最右边的节点
        while (right != null) {
            right = right.right;
            rightDeepth++;
        }
        if (leftDeepth == rightDeepth) {
            return (2 << leftDeepth) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
