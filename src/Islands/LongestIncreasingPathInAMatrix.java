package Islands;

public class LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        System.out.println(longestIncreasingPath(matrix));
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] memo = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                max = Math.max(max, dfs(matrix, i, j, memo));
            }
        }
        return max;
    }

    public static int dfs(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        // memo[i][j] 为 0，需将 (i, j) 位置计算在内
        memo[i][j]++;
        for (int k = 0; k < dx.length; ++k) {
            int x = i + dx[k], y = j + dy[k];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {
                // 每找到一个可以到达的位置 (x, y) 就需要将其计入路径长度中，即加 1
                memo[i][j] = Math.max(memo[i][j], dfs(matrix, x, y, memo) + 1);
            }
        }
        return memo[i][j];
    }
    

}
