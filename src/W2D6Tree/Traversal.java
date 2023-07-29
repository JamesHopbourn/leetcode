package W2D6Tree;

import common.TreeNode;

public class Traversal {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(7);
        System.out.println("前序：" + BinaryTreePreorderTraversal.preorderTraversal(tree));
        System.out.println("中序：" + BinaryTreeInorderTraversal.inorderTraversal(tree));
        System.out.println("后序：" + BinaryTreePostorderTraversal.postorderTraversal(tree));

        TreeNode.preorderTraversal(tree);System.out.println();
        TreeNode.inorderTraversal(tree);System.out.println();
        TreeNode.postorderTraversal(tree);System.out.println();
    }
}
