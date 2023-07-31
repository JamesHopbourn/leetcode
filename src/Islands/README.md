- [leetcode/thinkings/island.md at master · azl397985856/leetcode](https://github.com/azl397985856/leetcode/blob/master/thinkings/island.md)

#### 岛屿问题基本模版
```java
public static int function(int[][] grid) {
    if (grid == null) {
    return 0;
    }
    int variable = 0;
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == 1) {
                // 更新 variable 变量，例如比较最大值、自增加一
                dfs(grid, i, j);
            }
        }
    }
    return variable;
}

private static void dfs(int[][] grid, int i, int j) {
    // 如果超出范围        
    if (i < 0 || j < 0 || i >= grid.length || j > grid[0].length) {
        return;
    }
    // 如果不是陆地
    if (grid[i][j] != 1) {
        return;
    }
    // 标记走过
    grid[i][j] = 2;
    
    dfs(grid, i-1, j);
    dfs(grid, i+1, j);
    dfs(grid, i, j-1);
    dfs(grid, i, j+1);
}
```