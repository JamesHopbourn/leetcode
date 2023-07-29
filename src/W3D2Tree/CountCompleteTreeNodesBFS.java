package W3D2Tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/count-complete-tree-nodes/">222. 完全二叉树的节点个数 - 力扣（LeetCode）</a>
 * <a href="https://leetcode.cn/problems/count-complete-tree-nodes/solution/dsd-yong-wan-quan-er-cha-shu-ding-yi-qiu-le2l/">【DSD】用完全二叉树定义求完全二叉树结点数</a>
 * <a href="https://leetcode.cn/problems/count-complete-tree-nodes/solution/bfs-222-wan-quan-er-cha-shu-de-jie-dian-hy2ou/">【BFS】222. 完全二叉树的节点个数</a>
 */
public class CountCompleteTreeNodesBFS {
    public static void main(String[] args) {
        // 题目已经明确说给的都是完全二叉树
        System.out.println(countNodes(new TreeNode()));
        System.out.println(countNodes(TreeNode.createTree(1)));
        System.out.println(countNodes(TreeNode.createTree(2)));
        System.out.println(countNodes(TreeNode.createTree(3)));
        System.out.println(countNodes(TreeNode.createTree(4)));
        System.out.println(countNodes(TreeNode.createTree(5)));
    }

    public static int countNodes(TreeNode root) {
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
