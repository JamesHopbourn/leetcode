#### 589. N 叉树的前序遍历 - 力扣（LeetCode）
```c++
class Solution {
public:
    vector<int> result;
    vector<int> preorder(Node* root) {
        if (root != nullptr) {
            result.push_back(root->val);
            for (Node* node : root->children) {
                preorder(node);
            }
        }
        return result;
    }
};
```

#### 590. N 叉树的后序遍历
```c++
class Solution {
public:
    vector<int> result;
    vector<int> postorder(Node* root) {
        if (root != nullptr) {
            for (Node* node : root->children) {
                postorder(node);
            }
            result.push_back(root->val);
        }
        return result;        
    }
};
```

#### 429. N 叉树的层序遍历
```c++
class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
       vector<vector<int>> result;
        if (root == nullptr) {
            return result;
        }

        queue<Node*> queue;
        queue.push(root);
        while (!queue.empty()) {
            int size = queue.size();
            vector<int> path;
            while (size-->0) {
                Node* node = queue.front();
                queue.pop();
                path.push_back(node->val);
                for (Node* child : node->children) {
                    if (child != nullptr) queue.push(child);
                }
            }
            result.push_back(path);
        }
        return result;        
    }
};
```

#### 559. N 叉树的最大深度
```c++
class Solution {
public:
    int maxDepth(Node* root) {
        if (root == nullptr) return 0;
        int max = 0;
        for (Node* node : root->children) {
            max = std::max(max, maxDepth(node));
        }
        return max + 1;
    }
};
```
---
```c++
class Solution {
public:
    int maxDepth(Node* root) {
        if (root == nullptr) return 0;
        queue<Node*> queue;
        queue.push(root);

        int depth = 0;
        while (!queue.empty()) {
            depth++;
            int size = queue.size();
            while (size-->0) {
                Node* node = queue.front();
                queue.pop();
                for (Node* children : node->children) {
                    if (children != nullptr) queue.push(children);
                }
            }
        }
        return depth;
    }
};
```
