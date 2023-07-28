package W2D6Tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode createTree = TreeNode.createTree(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(inorderTraversal(createTree));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    public static void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);

        inorder(root.right, res);
    }
}
