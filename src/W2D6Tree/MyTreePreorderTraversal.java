package W2D6Tree;

import common.MyTree;

import java.util.ArrayList;
import java.util.List;

public class MyTreePreorderTraversal {
    public static void main(String[] args) {
        MyTree myTree = MyTree.constructTree(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(preorderTraversal(myTree));
    }

    public static List<Integer> preorderTraversal(MyTree root) {
        List<Integer> result = new ArrayList<>();
        preorder(result, root);
        return result;
    }

    public static void preorder(List<Integer> result, MyTree node) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        preorder(result, node.left);
        preorder(result, node.right);
    }
}
