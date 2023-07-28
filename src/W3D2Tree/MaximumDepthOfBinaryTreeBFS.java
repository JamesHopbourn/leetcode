package W3D2Tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTreeBFS {
    public static void main(String[] args) {
        System.out.println(maxDepth(TreeNode.createTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            count++;
        }
        return count;
    }
}
