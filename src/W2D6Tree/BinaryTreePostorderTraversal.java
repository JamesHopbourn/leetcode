package W2D6Tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        TreeNode createTree = TreeNode.createTree(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(postorderTraversal(createTree));
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        postorder(root, res);
        return res;
    }

    public static void postorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }
}
