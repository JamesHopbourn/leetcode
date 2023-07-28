package W3D3Tree;

import common.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/sum-of-left-leaves/submissions/">404. 左叶子之和 - 力扣（LeetCode）</a>
 * <a href="https://leetcode.cn/problems/sum-of-left-leaves/solution/zuo-xie-zi-zhi-he-by-leetcode-solution/">左叶子之和</a>
 */
public class SumOfLeftLeavesDFS {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{1});
        System.out.println("sumOfLeftLeaves(tree) = " + sumOfLeftLeaves(tree));

        TreeNode tree1 = TreeNode.createTree(new Integer[]{1, 2, 3, 4, 5});
        System.out.println("sumOfLeftLeaves(tree1) = " + sumOfLeftLeaves(tree1));

        TreeNode treeNode = TreeNode.createTree(new Integer[]{1});
        System.out.println("sumOfLeftLeaves(tree) = " + sumOfLeftLeaves(treeNode));

        TreeNode treeNode1 = TreeNode.createTree(new Integer[]{1, 2, 3, 4, 5});
        System.out.println("sumOfLeftLeaves(tree1) = " + sumOfLeftLeaves(treeNode1));
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        return root == null ? 0 : dfs(root);
    }

    public static boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static int dfs(TreeNode node){
        int sum = 0;
        if (node.left != null){
            sum += isLeafNode(node.left) ? node.left.val : dfs(node.left);
        }
        if (node.right != null){
            sum += dfs(node.right);
        }
        return sum;
    }
}
