package W2D6Tree;

import common.TreeNode;

public class Traversal {
    public static void main(String[] args) {
        System.out.println("前序：" + BinaryTreePreorderTraversal.preorderTraversal(TreeNode.createTree(7)));
        System.out.println("中序：" + BinaryTreeInorderTraversal.inorderTraversal(TreeNode.createTree(7)));
        System.out.println("后序：" + BinaryTreePostorderTraversal.postorderTraversal(TreeNode.createTree(7)));
    }
}
