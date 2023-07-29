package W3D2Tree;

import common.TreeNode;

public class MaximumDepthOfBinaryTreeDFS {
    public static void main(String[] args) {
        System.out.println(maxDepth(TreeNode.createTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return left > right ? left+1 : right+1;
        }
    }
}
