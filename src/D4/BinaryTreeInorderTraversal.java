package D4;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
            System.out.println(inorderTraversal(TreeNode.createTree(7)));
    }

    private static List<Integer> inorderTraversal(TreeNode tree) {
        List<Integer> integers = new ArrayList<>();
        inorder(tree, integers);
        return integers;
    }

    private static void inorder(TreeNode tree, List<Integer> integers) {
        if (tree == null){
            return;
        }
        inorder(tree.left, integers);
        integers.add(tree.val);
        inorder(tree.right, integers);
    }
}
