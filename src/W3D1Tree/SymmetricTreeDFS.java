package W3D1Tree;

import common.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/symmetric-tree/">101. 对称二叉树 - 力扣（LeetCode）</a>
 * <a href="https://leetcode.cn/problems/symmetric-tree/solution/di-gui-101-dui-cheng-er-cha-shu-by-turin-4r7d/">【递归】101. 对称二叉树</a>
 * <a href="https://leetcode.cn/problems/symmetric-tree/solution/dong-hua-yan-shi-101-dui-cheng-er-cha-shu-by-user7/">动画演示+多种实现 101. 对称二叉树</a>
 */
public class SymmetricTreeDFS {
    public static void main(String[] args) {
        System.out.println(isSymmetric(TreeNode.createTree(new Integer[]{1, 2, 2, 3, 4, 4, 3})));
        System.out.println(isSymmetric(TreeNode.createTree(new Integer[]{1, 2, 2, null, 3, null, 3})));
    }

    public static boolean isSymmetric(TreeNode root) {
         return root == null || check(root.left, root.right);
    }

    public static boolean check(TreeNode left, TreeNode right){
        // 相等，都为空的情况
        if (left == null && right == null){
            return true;
        }
        // 前面已经判断过两个都是空了，如果有走到这里，说明至多存在一个空节点，用或逻辑判断
        if (left == null || right == null){
            return false;
        }
        // 比较数值是否相等
        if (left.val != right.val){
            return false;
        }
        // 对称检查
        return check(left.left, right.right) && check(left.right, right.left);
    }
}
