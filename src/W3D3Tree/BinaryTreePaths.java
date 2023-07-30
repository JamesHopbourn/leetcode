package W3D3Tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        System.out.println(binaryTreePaths(TreeNode.createTree(new Integer[]{1, 2, 3, null, 5})));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(root, res, sb);
        return res;
    }

    private static void dfs(TreeNode node, List<String> res, StringBuilder s) {
        s.append(node.val);
        if (node.left == null && node.right == null) {
            res.add(s.toString());
            return;
        }
        if (node.left != null) {
            dfs(node.left, res, new StringBuilder(s).append("->"));
        }
        if (node.right != null) {
            dfs(node.right, res, new StringBuilder(s).append("->"));
        }
    }
}
