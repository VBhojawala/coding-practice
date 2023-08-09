package matrix;

public class RotateImage48 {
    public static void rotate(int[][] matrix) {
        int left=0, right= matrix.length-1;
        int top, bottom, topLeft;

        while (left < right){

            for (int i=0; i < right- left; i++){
                top = left;
                bottom= right;

                topLeft = matrix[top][left+i];
                matrix[top][left+i] = matrix[bottom-i][left];
                matrix[bottom-i][left] = matrix[bottom][right-i];
                matrix[bottom][right-i] = matrix[top+i][right];
                matrix[top+i][right] = topLeft;

            }
            right--;
            left++;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(matrix);
    }
}
