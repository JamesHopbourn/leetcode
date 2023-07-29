package W3D2Tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTreeBFS {
    public static void main(String[] args) {
        System.out.println(minDepth(TreeNode.createTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
        System.out.println(minDepth(TreeNode.createTree(new Integer[]{2, null, 3, null, 4, null, 5, null, 6})));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            level++;
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
        return level;
    }
}
