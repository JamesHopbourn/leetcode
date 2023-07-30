package Islands;

public class ReviewMaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        int maxIslandArea = getMaxIslandArea(matrix);
        System.out.println(maxIslandArea);
    }

    public static int getMaxIslandArea(int[][] matrix){
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1){
                    max = Math.max(max, dfs(matrix, i, j));
                }
            }
        }
        return max;
    }

    private static int dfs(int[][] matrix, int i, int j) {
        if (i <0 || j < 0 || i>=matrix.length || j >= matrix[0].length){
            return 0;
        }
        if (matrix[i][j] != 1){
            return 0;
        }
        matrix[i][j] = 2;
        int area = 1;
        area += dfs(matrix, i-1, j);
        area += dfs(matrix, i+1, j);
        area += dfs(matrix, i, j-1);
        area += dfs(matrix, i, j+1);
        return area;
    }
}
