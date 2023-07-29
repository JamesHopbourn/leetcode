package W3D5Tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 这道题用 BFS 解相对来说比较麻烦，适合 DFS，如果用 BFS 是中等，DFS 就是简单
 * <a href="https://leetcode.cn/problems/merge-two-binary-trees/">617. 合并二叉树 - 力扣（LeetCode）</a>
 * <a href="https://leetcode.cn/problems/merge-two-binary-trees/solution/he-bing-er-cha-shu-by-leetcode-solution/">合并二叉树</a>
 */
public class MergeTwoBinaryTreesBFS {
    public static void main(String[] args) {
        TreeNode.show(merge(TreeNode.createTree(new Integer[]{1, 3, 2, 5}), TreeNode.createTree(new Integer[]{2, 1, 3, null, 4, null, 7})));
    }

    public static TreeNode merge(TreeNode t1, TreeNode t2){
        if (t1 == null){
            return t2;
        }
        if (t2 == null){
            return t1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        TreeNode merged = new TreeNode(t1.val + t2.val);
        queue.add(merged);
        leftQueue.add(t1);
        rightQueue.add(t2);
        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode node1 = leftQueue.poll();
            TreeNode node2 = rightQueue.poll();
            TreeNode left1 = node1.left;
            TreeNode left2 = node2.left;
            TreeNode right1 = node1.right;
            TreeNode right2 = node2.right;
            if (left1 != null || left2 != null){
                if (left1 != null && left2 != null){
                    TreeNode left = new TreeNode(left1.val + left2.val);
                    node.left = left;
                    queue.add(left);
                    // 想清楚，这里到底 add 是什么，不要搞混了
                    leftQueue.add(left1);
                    rightQueue.add(left2);
                } else if (left1 != null){
                    node.left = left1;
                } else if (left2 != null){
                    node.left = left2;
                }
            }

            if (right1 != null || right2 != null){
                if (right1 != null && right2 != null){
                    TreeNode right = new TreeNode(right1.val + right2.val);
                    node.right = right;
                    queue.add(right);
                    leftQueue.add(right1);
                    rightQueue.add(right2);
                } else if (right1 != null){
                    node.right = right1;
                } else if (right2 != null){
                    node.right = right2;
                }
            }
        }
        return merged;
    }

    /**
     * 下面这个是代码简化版本
     * @param t1
     * @param t2
     * @return
     */
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null){
            return t2;
        }
        if (t2 == null){
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        Queue<TreeNode> mergeQueue = new LinkedList<>();
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        mergeQueue.add(merged);
        leftQueue.add(t1);
        rightQueue.add(t2);
        // 两个 BFS 叠加 逐步去写就基本没问题了
        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()){
            TreeNode node = mergeQueue.poll();
            TreeNode node1 = leftQueue.poll();
            TreeNode node2 = rightQueue.poll();
            if (node1.left != null || node2.left != null){
                if (node1.left != null && node2.left != null){
                    TreeNode left = new TreeNode(node1.left.val + node2.left.val);
                    node.left = left;
                    mergeQueue.add(left);
                    leftQueue.add(node1.left);
                    rightQueue.add(node2.left);
                } else if (node1.left != null){
                    node.left = node1.left;
                } else if (node2.left != null){
                    node.left = node2.left;
                }
            }
            if (node1.right != null || node2.right != null){
                if (node1.right != null && node2.right != null){
                    TreeNode right = new TreeNode(node1.right.val + node2.right.val);
                    node.right = right;
                    mergeQueue.add(right);
                    leftQueue.add(node1.right);
                    rightQueue.add(node2.right);
                } else if (node1.right != null){
                    node.right = node1.right;
                } else if (node2.right != null){
                    node.right = node2.right;
                }
            }
        }
        return merged;
    }
}
