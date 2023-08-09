package matrix;

public class ValidSudoku36 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] sqr = new boolean[9][9];

        for(int i=0; i<9; i++){
            for (int j=0; j < 9; j++){

                if (board[i][j] == '.')
                    continue;

                int cur = board[i][j] - '0' - 1;
                int sqrIndex = (i/3) * 3 + j/3;

                if(row[i][cur] || col[j][cur] || sqr[sqrIndex][cur])
                    return false;

                row[i][cur] = true;
                col[j][cur] = true;
                sqr[sqrIndex][cur] = true;

            }
        }
        return true;
    }
}
