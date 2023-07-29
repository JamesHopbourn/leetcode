package W3D3Tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/sum-of-left-leaves/submissions/">404. 左叶子之和 - 力扣（LeetCode）</a>
 * <a href="https://leetcode.cn/problems/sum-of-left-leaves/solution/zuo-xie-zi-zhi-he-by-leetcode-solution/">左叶子之和</a>
 */
public class SumOfLeftLeavesBFS {
    public static void main(String[] args) {
        System.out.println(sumOfLeftLeaves(TreeNode.createTree(new Integer[]{1})) == 0);
        System.out.println(sumOfLeftLeaves(TreeNode.createTree(new Integer[]{1, 2, 3})) == 2);
        System.out.println(sumOfLeftLeaves(TreeNode.createTree(new Integer[]{1, 2, 3, 4, 5})) == 4);
        System.out.println(sumOfLeftLeaves(TreeNode.createTree(new Integer[]{1, 2, 3, 4, 5, 6})) == 10);
        System.out.println(sumOfLeftLeaves(TreeNode.createTree(new Integer[]{3, 9, 20, null, null, 15, 7})) == 24);
    }

    public static boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    /**
     * 广度优先搜索 <p>
     * 思路类似 {@link W2D6Tree.BinaryTreeLevelOrderTraversal}
     */
    public static int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                // // 此处要做一个判断是不是叶子结点！！
                if (isLeafNode(node.left)) {
                    sum += node.left.val;
                } else {
                    queue.add(node.left);
                }
            }
            // 此处一定要注意是添加非叶子节点！！
            if (node.right != null && !isLeafNode(node.right)) {
                queue.add(node.right);
            }
        }
        return sum;
    }
}
