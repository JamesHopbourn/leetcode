package W3D1Tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/symmetric-tree/">101. 对称二叉树 - 力扣（LeetCode）</a>
 * <a href="https://leetcode.cn/problems/symmetric-tree/solution/di-gui-101-dui-cheng-er-cha-shu-by-turin-4r7d/">【递归】101. 对称二叉树</a>
 * <a href="https://leetcode.cn/problems/symmetric-tree/solution/dong-hua-yan-shi-101-dui-cheng-er-cha-shu-by-user7/">动画演示+多种实现 101. 对称二叉树</a>
 */
public class SymmetricTreeBFS {
    public static void main(String[] args) {
        System.out.println(isSymmetric(TreeNode.createTree(new Integer[]{1, 2, 2, 3, 4, 4, 3})));
    }

    /**
   下面的逻辑思路和 {@link SymmetricTreeDFS} 大同小异，只是表现形式不同
   */
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
