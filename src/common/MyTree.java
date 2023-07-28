package common;

import java.util.LinkedList;
import java.util.Queue;

public class MyTree {
    public int val;
    public MyTree left;
    public MyTree right;

    public MyTree() {
    }

    public MyTree(int val) {
        this.val = val;
    }

    public MyTree(int val, MyTree left, MyTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static MyTree constructTree(Integer[] array) {
        if (array.length == 0){
            return null;
        }
        MyTree root = new MyTree(array[0]);
        Queue<MyTree> queue = new LinkedList<>();
        queue.add(root);

        for (int i = 1; i < array.length; i++) {
            MyTree node = queue.peek();
            if (i % 2 == 1) {
                if (array[i] != null){
                    node.left = new MyTree(array[i]);
                    queue.add(node.left);
                }
            } else {
                if (array[i] != null){
                    node.right = new MyTree(array[i]);
                    queue.add(node.right);
                }
                queue.poll();
            }
        }
        return root;
    }
}
