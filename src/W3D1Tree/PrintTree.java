package W3D1Tree;

import common.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class PrintTree {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        print(tree);
    }

    public static void print(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int indent = 0;
        String indentString = "\t";

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!isLeafNode(node)){
                System.out.print(String.join("", Collections.nCopies(indent, indentString)));
                System.out.println("val: " + node.val);
            }
            indent++;
            if (node.left != null) {
                System.out.print(String.join("", Collections.nCopies(indent, indentString)));
                System.out.println("l: " + node.left.val);
                queue.add(node.left);
            }
            if (node.right != null) {
                System.out.print(String.join("", Collections.nCopies(indent, indentString)));
                System.out.print("r: " + node.right.val);
                queue.add(node.right);
            }
            if (!isLeafNode(node)){
                System.out.println();
            }
        }
    }

    public static boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
