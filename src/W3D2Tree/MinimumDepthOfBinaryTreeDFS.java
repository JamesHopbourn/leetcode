package W3D2Tree;

import common.TreeNode;

public class MinimumDepthOfBinaryTreeDFS {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(minDepth(tree));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (root.left != null && root.right == null) {
            return left + 1;
        } else if (root.left == null && root.left != null) {
            return right + 1;
        }
        return left < right ? left + 1 : right + 1;
    }
}
