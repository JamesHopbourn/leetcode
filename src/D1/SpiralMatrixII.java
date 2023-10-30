package D1;

public class SpiralMatrixII {
    public static void main(String[] args) {
        int[][] matrix = generateMatrix(3);
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int top = 0, button = n - 1;
        int left = 0, right = n - 1;
        int count = 1;
        while (count <= n * n && top <= button && left <= right) {
            for (int i = 0; i < right - left; i++) {
                result[top][left + i] = count;
                count++;
            }
            for (int i = 0; i < button - top; i++) {
                result[top + i][right] = count;
                count++;
            }
            for (int i = 0; i < right - left; i++) {
                result[button][right - i] = count;
                count++;
            }
            for (int i = 0; i < button - top; i++) {
                result[button - i][left] = count;
                count++;
            }
            if (button == top && left == right) {
                result[top][left] = count;
                count++;
            }
            top++;
            button--;
            left++;
            right--;
        }
        return result;
    }
}
