package W3D4Tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/find-bottom-left-tree-value/solution/zhao-shu-zuo-xia-jiao-de-zhi-by-leetcode-weeh/">找树左下角的值 - 找树左下角的值 - 力扣（LeetCode）</a>
 */
public class FindBottomLeftTreeValue {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(findBottomLeftValue(TreeNode.createTree(1 << i)));
        }
    }

    public static int findBottomLeftValue(TreeNode root) {
        int num = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            num = node.val;
            // 注意：找左下角的值 要从右到左去添加节点队列，这样才能保证最后返回是最左边的值
            if (node.right != null){
                queue.add(node.right);
            }
            if (node.left != null){
                queue.add(node.left);
            }
        }
        return num;
    }
}
