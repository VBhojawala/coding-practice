package matrix;

public class LonelyPixelI531 {
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length, n = picture[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        for (int i=0; i< m ; i++){
            for (int j=0; j< n; j++){
                if (picture[i][j] == 'B')
                {
                    rowCount[i]++;
                    colCount[j]++;
                 }
            }
        }

        int count =0;
        for (int i=0; i< m ; i++){
            if (rowCount[i] !=1) continue;
            for (int j=0; j< n ; j++){
                if (colCount[j] == 1 && picture[i][j] == 'B'){
                    count++;
                    break;
                }

            }
        }

        return count;
    }
}
