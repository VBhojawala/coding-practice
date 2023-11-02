package arrays;

public class MatrixDiagonalSum1572 {
    public int diagonalSum(int[][] mat) {
        int n = mat.length, sum = 0;

        for (int i=0; i < n; i++){
            sum += mat[i][i];
            int j = n-i-1;
            sum += (i == j) ? 0 : mat[i][j];
        }

        return sum;
    }
}
