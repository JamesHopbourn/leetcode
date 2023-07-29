package W3D5Tree;

import common.TreeNode;

/**
 * 这道题用 BFS 解相对来说比较麻烦，适合 DFS，如果用 BFS 是中等，DFS 就是简单
 * <a href="https://leetcode.cn/problems/merge-two-binary-trees/">617. 合并二叉树 - 力扣（LeetCode）</a>
 * <a href="https://leetcode.cn/problems/merge-two-binary-trees/solution/he-bing-er-cha-shu-by-leetcode-solution/">合并二叉树</a>
 */
public class MergeTwoBinaryTreesDFS {
    public static void main(String[] args) {
        TreeNode.show(mergeTrees(TreeNode.createTree(new Integer[]{1, 3, 2, 5}), TreeNode.createTree(new Integer[]{2, 1, 3, null, 4, null, 7})));
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null){
            return t2;
        }
        if (t2 == null){
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;
    }
}
