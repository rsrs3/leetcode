package binarysearch;

/**
 * Created by rajat on 6/23/16.
 */
public class SearchMatrix2 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            int num = matrix[row][col];
            if (target > num) row++;
            else if (target < num) col--;
            else return true;
        }
        return false;
    }
}
