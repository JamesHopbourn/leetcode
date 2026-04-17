# Java -> C++ LeetCode 语法迁移速查表

适用场景：
- 已经会 Java
- 现在要快速刷 C++ 算法题
- 目标不是系统学 C++ 工程开发，而是先把常见题型写对

---

# 1. 最高频基础替换

说明：
- 在 LeetCode 二叉树、链表题里，节点通常都是指针，所以 `TreeNode`、`ListNode` 基本都要带 `*`
- 一旦是指针，访问字段就不能写 `.`，而要写 `->`

例子：

Java:
```java
TreeNode root = node.left;
if (root.right == null) {
    return;
}
```

---

# 2. 字符串相关替换

## 2.1 StringBuilder 怎么替换

Java:
```java
StringBuilder builder = new StringBuilder();
builder.append("->");
builder.append(root.val);
String s = builder.toString();
```

核心规则：

注意：
- 不是 `to_String()`
- 正确写法是 `to_string()`
- 全小写

---

# 3. 常见容器替换

补充：

说明：
- 刷题里一般优先用 `unordered_map`、`unordered_set`，因为你通常想要哈希表语义
- `vector` 是最常用动态数组
- `queue`、`stack` 是容器适配器，接口和 Java 不完全一样

---

# 4. queue 队列替换

Java:
```java
Queue<TreeNode> queue = new LinkedList<>();
queue.add(root);
while (!queue.isEmpty()) {
    TreeNode node = queue.poll();
}
```

核心替换：

最重要的一条：

在 C++ 里：
- 只删除
- 不返回值

所以必须写成：

不能写成：

这是错的。

---

# 5. stack 栈替换

Java:
```java
Stack<Integer> stack = new Stack<>();
stack.push(1);
int x = stack.pop();
int y = stack.peek();
boolean b = stack.isEmpty();
```

核心替换：

注意：
- C++ 的 `stack.pop()` 也不返回值
- 先 `top()`，再 `pop()`

正确写法：

---

# 6. vector 动态数组替换

Java:
```java
ArrayList<Integer> list = new ArrayList<>();
list.add(1);
int x = list.get(0);
int n = list.size();
```

核心替换：

补充：

这在回溯题里很常见。

---

# 7. map / set 替换

## 7.1 HashMap -> unordered_map

Java:
```java
HashMap<Integer, Integer> map = new HashMap<>();
map.put(1, 2);
int v = map.get(1);
boolean b = map.containsKey(1);
```

核心替换：

注意：
- `map[k]` 如果 key 不存在，会默认创建
- 只想判断是否存在，优先用 `count()`

## 7.2 HashSet -> unordered_set

Java:
```java
HashSet<Integer> set = new HashSet<>();
set.add(1);
boolean b = set.contains(1);
set.remove(1);
```

核心替换：

---

# 8. 二叉树题最常见改法

## 8.1 空节点判断

Java:
```java
if (root == null)
```

## 8.2 左右子节点访问

Java:
```java
root.left
root.right
```

## 8.3 DFS 函数参数

Java:
```java
public void dfs(TreeNode root)
```

---

# 9. 链表题最常见改法

Java:
```java
ListNode head = new ListNode(0);
head.next = node;
if (head.next == null) {
    return null;
}
```

核心记忆：

---

# 10. 回溯题常见替换

Java:
```java
List<Integer> path = new ArrayList<>();
path.add(num);
path.remove(path.size() - 1);
result.add(new ArrayList<>(path));
```

核心替换：

说明：
- `vector` 赋值会拷贝当前内容，所以 `result.push_back(path)` 就相当于保存当前路径快照

---

# 11. BFS 模板

## 11.1 普通层序遍历

## 11.2 BFS 常见错误

### 错误 1：忘记判空

如果 `root == nullptr`，后面 `node->left` 会崩。

### 错误 2：把 `pop()` 当成返回值

错误：

正确：

### 错误 3：指针还在用 `.`

错误：

正确：

---

# 12. DFS 模板

如果需要路径字符串：

---

# 13. 你当前最该记住的机械替换表

---

# 14. 采用阈值

适合直接按这份速查表硬切换的情况：
- LeetCode 基础题
- 二叉树 / 链表 / BFS / DFS / 回溯
- 目标是先把题做出来
- 你本质上是在用 Java 思维写 C++ 题解

不适合只靠这份表硬上的情况：
- 指针生命周期复杂
- 手写链表操作很多
- 涉及引用 `&`
- 涉及类设计、模板、移动语义、RAII
- 涉及工程级 C++ 开发

也就是说：
- 刷题阶段，这份够用
- 真要做 C++ 工程，这份远远不够

---

# 15. 风险点清单

## 高风险 1：忘记 `*`

错误：

正确：

## 高风险 2：忘记 `->`

错误：

正确：

## 高风险 3：把 `pop()` 当返回值

错误：

正确：

## 高风险 4：字符串拼数字

错误：

正确：

## 高风险 5：空树没判空

错误：

在 `root == nullptr` 时可能崩。

正确：

---

# 16. 回滚策略

如果你某道题改着改着乱了，就按下面顺序排查：

1. `null` 是否都改成了 `nullptr`
2. `TreeNode / ListNode` 是否都补成了指针 `*`
3. 所有节点字段访问是不是都改成了 `->`
4. `queue.pop()` / `stack.pop()` 前是不是先取 `front()` / `top()`
5. `string` 拼数字是不是加了 `to_string()`
6. BFS 开头有没有判空

这 6 项能解决你现在 80% 以上的 Java -> C++ 刷题错误。

---

# 17. 一句话总结

你现在学 C++ 刷题，不是要先学完整 C++，而是要先掌握一套“Java 题解到 C++ 题解”的机械映射规则。

先把题写对，再慢慢补语言细节，这条路径对你现在最省时间。
