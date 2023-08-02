package binarySearch;

public class Search2DMatrix74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n= matrix[0].length;
        int l= 0, r= m * n -1, mid =0;
        int x,y;

        while (l < r){
            mid = l + ((r-l) / 2);
            x = mid / n;
            y = mid % n;

            if(matrix[x][y] >= target)
                r = mid;
            else
                l = mid+1;
        }

        return matrix[l / n][l % n] == target;
    }

}
