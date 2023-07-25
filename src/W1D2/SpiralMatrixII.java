package W1D2;


/**
 * https://www.bilibili.com/video/BV1qp4y1h7cq
 * https://ls8sck0zrg.feishu.cn/wiki/NxThweD48iXGmdk90oTcK7UInmc
 */
public class SpiralMatrixII {
    public static void main(String[] args) {
        int[][] matrix = generateMatrix(10);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
                if (matrix[i][j] <= 9){ System.out.print(" "); }
            }
            System.out.println();
        }
    }
    
    public static int[][] generateMatrix(int n){
        int[][] result = new int[n][n];
        int top = 0, button = n - 1;
        int left = 0, right = n - 1;
        int count = 1;
        
        /*
          向右 for (int i = 0; i < right - left; i++){ result[top][left+i] = count; count++; }
          向下 for (int i = 0; i < button - top; i++){ result[top+i][right] = count; count++; }
          向左 for (int i = 0; i < right - left; i++){ result[button][right-i] = count; count++; }
          向上 for (int i = 0; i < button - top; i++){ result[button-i][left] = count; count++; }
         */
        while (count <= n*n && top <= button && left <= right){
            /*
              1, 2
              left = 0
              right = 2
              right - left = 2
              result[0][0] = 1;
              result[0][1] = 2;
             */
            for (int i = 0; i < right - left; i++){ result[top][left+i] = count; count++; }
            /*
            3, 4
            button = 2;
            top = 0;
            button - top = 2
            result[0][2] = 3
            result[1][2] = 4
             */
            for (int i = 0; i < button - top; i++){ result[top+i][right] = count; count++; }
            /*
            5, 6
            button = 2
            right = 2
            left = 0
            result[2][2] = 5
            result[2][1] = 6
             */
            for (int i = 0; i < right - left; i++){ result[button][right-i] = count; count++; }
            /*
            7, 8
            button - top = 2
            result[2][0] = 7
            result[1][0] = 8
             */
            for (int i = 0; i < button - top; i++){ result[button-i][left] = count; count++; }
            // 聚拢到中间了，赋值
            if (button == top && left == right){
                result[top][left] = count;
                count++;
            }
            // 向中心聚拢
            top++;
            button--;
            left++;
            right--;
        }
        return result;
    }
}
