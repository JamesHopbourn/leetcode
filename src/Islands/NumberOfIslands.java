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

    public static void dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return;
        }
        if (grid[r][c] == 0) {
            return;
        }
        grid[r][c] = 0;
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}
