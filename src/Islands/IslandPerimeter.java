package Islands;

public class IslandPerimeter {
    public static void main(String[] args) {
        System.out.println(islandPerimeter(new int[][]{{1}}) == 4);
        System.out.println(islandPerimeter(new int[][]{{1, 0}}) == 4);
        System.out.println(islandPerimeter(new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}}) == 16);
    }

    public static int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    private static int dfs(int[][] grid, int i, int j) {
        // 超出边界 +1
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return 1;
        }
        // 碰到海边 +1
        if (grid[i][j] == 0){
            return 1;
        }
        // 遍历过了
        if (grid[i][j] != 1){
            return 0;
        }
        // 标记走过
        grid[i][j] = 2;
        return dfs(grid, i - 1, j) + dfs(grid, i + 1, j) + dfs(grid, i, j-1) + dfs(grid, i, j+1);
    }
}
