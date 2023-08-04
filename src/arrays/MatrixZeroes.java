package arrays;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
public class MatrixZeroes {

    /*
        Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.
        You must do it in place.
        Example:
        Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
        Output: [[1,0,1],[0,0,0],[1,0,1]]
    */
    /*  The first solution that comes to my mind as brute force approach is that we can iterate for each array of
        the matrix, and when we find a 0, we save the current row and col indexes into another array.
        We will use later the indexes that we saved earlier for setting to 0 the corresponding rows and cols indexes.
     */
    public void setZeroesBruteForce(int[][] matrix) {
        // declare a map that will store the row index and the col index of the zeroes found
        Set<Integer> zeroesColIndexes = new HashSet<>();
        Set<Integer> zeroesRowIndexes = new HashSet<>();

        // iterate for each array of the matrix, and then for each element of the array, when a zero is found
        // we put the indexes of the row and the col into the map
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroesColIndexes.add(j);
                    zeroesRowIndexes.add(i);

                }
            }
            System.out.println("Col indexes:" + zeroesColIndexes);
            System.out.println("Row indexes:" + zeroesRowIndexes);
        }

        // 1,1,1    index 0
        // 1,0,1    index 1
        // 1,1,1    index 2

        // iterate for each array of the matrix, if the current row index is contained in the zeroesRowIndexes
        // set all the element to 0 and continue the loop, if not, check if the current colum should be zeroed
        for (int i = 0; i < matrix.length; i++) {
            boolean shouldRowBeZeroed = false;
            for (int j = 0; j < matrix[i].length; j++) {
                if (zeroesRowIndexes.contains(i)) {
                    shouldRowBeZeroed = true;
                } else if (zeroesColIndexes.contains(j)) {
                    matrix[i][j] = 0;
                }
                if (shouldRowBeZeroed) {
                    matrix[i][j] = 0;
                }
            }
        }

        System.out.println(Arrays.deepToString(matrix));
    }
}
