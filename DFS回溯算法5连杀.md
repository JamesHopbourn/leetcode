#### 17. 电话号码的字母组合
```java
class Solution {
    StringBuilder sb = new StringBuilder();
    List<String> result = new LinkedList<>();
    String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }
        dfs(digits, 0);
        return result;
    }

    public void dfs(String digits, int num) {
        if (digits.length() == num) {
            result.add(sb.toString());
            return;
        }
        String map = numString[digits.charAt(num) - '0'];
        for (char c : map.toCharArray()) {
            sb.append(c);
            dfs(digits, num + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
```

#### 93. 复原 IP 地址
```java
class Solution {
    List<String> path = new LinkedList();
    List<String> result = new LinkedList();

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0);
        return result;
    }

    public void dfs(String s, int i, int k) {
        if (k == 4) {
            if (i == s.length()) result.add(String.join(".", path));
            return;
        }
        for (int j = i; j < s.length() && j < i + 3; j++) {
            if (s.charAt(i) == '0' && j > i)
                return;
            int num = Integer.parseInt(s.substring(i, j + 1));
            if (num >= 0 && num <= 255) {
                path.add(s.substring(i, j + 1));
                dfs(s, j + 1, k + 1);
                path.removeLast();
            }
        }
    }
}
```

#### 491. 非递减子序列
```java
class Solution {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    public void backtracking(int[] nums, int startIndex) {
        if (path.size() >= 2) {
            result.add(new LinkedList<>(path));
        }
        boolean[] used = new boolean[201];
        for (int i = startIndex; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.getLast() || used[nums[i] + 100]) {
                continue;
            }
            // -100 <= nums[i] <= 100
            used[nums[i] + 100] = true;
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }
}
```

#### 51. N 皇后
```java
class Solution {
    List<List<String>> result = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] row : chessboard){
            Arrays.fill(row, '.');
        }
        backtrack(n, 0, chessboard);
        return result;
    }

    public void backtrack(int n, int row, char[][] chessboard){
        // 如果当前行数等于棋盘大小，表示找到了一个解，将解转化为字符串列表并添加到结果集中
        if (n == row){
            List<String> convert = new ArrayList<>();
            for (char[] c : chessboard){
                convert.add(String.valueOf(c));
            }
            result.add(convert);
            return;
        }

        // 遍历当前行的所有列
        for (int col = 0; col < n; col++){
            // 如果当前位置可以放置皇后（不冲突），则尝试放置皇后并进入下一行的回溯
            if(isValid(row, col, n, chessboard)){
                chessboard[row][col] = 'Q';
                backtrack(n, row + 1, chessboard);
                chessboard[row][col] = '.'; // 回溯，将当前位置重新置为 '.'
            }
        }
    }


    public boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列是否有皇后
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查左上方对角线是否有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查右上方对角线是否有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 如果通过以上检查，则位置合法
        return true;
    }
}
```

#### 37. 解数独
```java
```