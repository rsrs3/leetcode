package Arrays;

import java.util.Arrays;

/**
 * Created by rajat on 6/26/16.
 */
public class SpiralMatrix2 {

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if (n <= 0) return result;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int dir = 0, val = 1;
        while (top <= bottom && left <= right) {
            if (dir == 0) {
                for (int i = left; i <= right; ++i) {
                    result[top][i] = val++;
                }
                top++;
            }

            if (dir == 1) {
                for (int i = top; i <= bottom; ++i) {
                    result[i][right] = val++;
                }
                right--;
            }

            if (dir == 2) {
                for (int i = right; i >= left; --i) {
                    result[bottom][i] = val++;
                }
                bottom--;
            }

            if (dir == 3) {
                for (int i = bottom; i >= top; --i) {
                    result[i][left] = val++;
                }
                left++;
            }
            dir = (dir + 1) % 4;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] result = new SpiralMatrix2().generateMatrix(1);
        for(int[] row:result){
            System.out.println(Arrays.toString(row));
        }
    }
}
