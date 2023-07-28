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
        TreeNode tree = TreeNode.createTree(new Integer[]{1});
        System.out.println("sumOfLeftLeaves(tree) = " + sumOfLeftLeaves(tree));

        TreeNode tree1 = TreeNode.createTree(new Integer[]{1, 2, 3, 4, 5});
        System.out.println("sumOfLeftLeaves(tree1) = " + sumOfLeftLeaves(tree1));

        TreeNode treeNode = TreeNode.createTree(new Integer[]{1});
        System.out.println("sumOfLeftLeaves(tree) = " + sumOfLeftLeaves(treeNode));

        TreeNode treeNode1 = TreeNode.createTree(new Integer[]{1, 2, 3, 4, 5});
        System.out.println("sumOfLeftLeaves(tree1) = " + sumOfLeftLeaves(treeNode1));
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

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.left != null){
                // // 此处要做一个判断是不是叶子结点！！
                if (isLeafNode(node.left)){
                    sum += node.left.val;
                } else {
                    queue.add(node.left);
                }
            }
            // 此处一定要注意是添加非叶子节点！！
            if (node.right != null && !isLeafNode(node.right)){
                queue.add(node.right);
            }
        }
        return sum;
    }

    public static int dfs(TreeNode node){
        int sum = 0;
        if (node.left != null){
            sum += isLeafNode(node.left) ? node.left.val : dfs(node.left);
        }
        if (node.right != null){
            sum += dfs(node.right);
        }
        return sum;
    }
}
