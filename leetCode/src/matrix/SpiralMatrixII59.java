package matrix;

public class SpiralMatrixII59 {

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int num = 1;
        int top = 0 , bottom = n-1, left = 0, right= n-1;

        while (num <= (n*n)){
            for (int col= left; col <= right; col++)
                result[top][col] = num++;
            for (int row=top +1; row <= bottom; row++)
                result[row][right] = num++;

            if (top != bottom){
                for (int col=right-1; col>= left; col--)
                    result[bottom][col] = num++;
            }

            if (left != right){
                for (int row= bottom-1; row > top; row--)
                    result[row][left] = num++;
            }

            left++; right--;
            top++; bottom--;

        }

        return result;
    }

    public static void main(String[] args) {
        SpiralMatrixII59 prog = new SpiralMatrixII59();
        var n = 5;
        var result = prog.generateMatrix(n);
        for (int i=0; i<n ; i++){
            for (int j=0; j<n; j++){
                System.out.print(" "+ result[i][j]);
            }
            System.out.println("");
        }
    }

}
