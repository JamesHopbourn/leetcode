package Islands;

public class ReviewNumberOfIsland {
    public static void main(String[] args) {

        System.out.println(numIslands(new int[][]{
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 0, 0, 1, 0},
                {0, 1, 0, 1, 0}
        }));
    }

    public static int numIslands(int[][] matrix) {
        int variable = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    // 更新 variable 变量，例如比较最大值、自增加一
                    dfs(matrix, i, j);
                }
            }
        }
        return variable;
    }

    private static void dfs(int[][] matrix, int i, int j) {
        // 如果超出范围
        if (i < 0 || j < 0 || i >= matrix.length || j > matrix[0].length) {
            return;
        }
        // 如果不是陆地
        if (matrix[i][j] != 1) {
            return;
        }
        // 标记走过
        matrix[i][j] = 2;

        dfs(matrix, i-1, j);
        dfs(matrix, i+1, j);
        dfs(matrix, i, j-1);
        dfs(matrix, i, j+1);
    }
}
