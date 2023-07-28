package W2D6Tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        List<List<Integer>> lists = levelOrder(tree);
        System.out.println(lists);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        // 这里一定要做判空，否则 null 或者 [] 都会报错
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            // 记录当前层的数据
            List<Integer> level = new ArrayList<>();
            while (count-- > 0) {
                // 记录一下再 pop，因为后面要判断左右节点是否存在
                TreeNode node = queue.peek();
                queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}
