package Islands;

/**
 * <a href="https://leetcode.cn/problems/number-of-islands/">200. 岛屿数量 - 力扣（LeetCode）</a>
 * <a href="https://leetcode.cn/problems/number-of-islands/solution/dao-yu-shu-liang-by-leetcode/">岛屿数量</a>
 * <a href="https://leetcode.cn/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-">岛屿类问题的通用解法、DFS 遍历框架</a>
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        int[][] array = {
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 0, 0, 1, 0},
                {0, 1, 0, 1, 0}
        };
        System.out.println(numIslands(array));
    }

    public static int numIslands(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int islandNum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    islandNum++;
                    dfs(grid, i, j);
                }
            }
        }
        return islandNum;
    }

    public static void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
