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
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int num_islands = 0;
        for (int r = 0; r < grid.length; ++r) {
            for (int c = 0; c < grid[0].length; ++c) {
                if (grid[r][c] == 1) {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }
        return num_islands;
    }
    
    public static void dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) {
            return;
        }
        if (grid[r][c] == 0){
            return;
        }
        grid[r][c] = 0;
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}
