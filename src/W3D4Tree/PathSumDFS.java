package W3D4Tree;

import common.TreeNode;

public class PathSumDFS {
    public static void main(String[] args) {
        System.out.println(hasPathSum(TreeNode.createTree(new Integer[]{1, 2, 3}), 5));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null){
                return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
