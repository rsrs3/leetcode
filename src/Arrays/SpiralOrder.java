package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rajat on 6/26/16.
 */
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;

        int m = matrix.length, n = matrix[0].length;

        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        int dir = 0;
        while (top <= bottom && left <= right) {

            if (dir == 0) {
                for (int i = left; i <= right; i++)
                    result.add(matrix[top][i]);
                top++;
            }

            if (dir == 1) {
                for (int i = top; i <= bottom; i++)
                    result.add(matrix[i][right]);
                right--;
            }

            if (dir == 2) {
                for (int i = right; i >= left; --i) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (dir == 3) {
                for (int i = bottom; i >= top; --i) {
                    result.add(matrix[i][left]);
                }
                left++;
            }

            dir = (dir + 1) % 4;
        }
        return result;
    }
}
