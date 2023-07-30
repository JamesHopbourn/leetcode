package W3D1Tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTreeBFS {
    public static void main(String[] args) {
        System.out.println(isSymmetric(TreeNode.createTree(new Integer[]{1, 2, 2, 3, 4, 4, 3})));
    }

    public static boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null){
                continue;
            }
            if (left == null || right == null){
                return false;
            }
            if (left.val != right.val){
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }
}
