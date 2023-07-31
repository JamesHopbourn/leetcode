#### 二叉树遍历基本模版
```java
public static int function(TreeNode root){
    if (root == null){
        return 0;    
    }
    int variable = 0;
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()){
        TreeNode node = queue.poll();
        if (node.left != null){
            // 更新 variable
            queue.add(node.left);
        }
        if (node.right != null){
            // 更新 variable
            queue.add(node.right);
        }
    }
    return variable;
}
```