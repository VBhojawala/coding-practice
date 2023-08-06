package Matrix;

public class GameOfLife289 {
    public void gameOfLife(int[][] board) {

        for (int i=0;i <board.length;i++){
            for (int j=0; j< board[0].length; j++){
                int neighbours = countNeighbours(board, i, j);
                if(board[i][j] == 1 ) {
                    if (neighbours == 2 || neighbours == 3)
                        board[i][j] = 3;
                }else if(neighbours == 3){
                    board[i][j] =2;
                }
            }
        }


        for (int i=0;i <board.length;i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1)
                    board[i][j] = 0;
                else if (board[i][j] == 2 || board[i][j] ==3)
                    board[i][j] =1;
            }
        }
    }

    private int countNeighbours(int[][] board, int row, int col){
        int neighbours = 0;

        for (int i=row-1; i<row+2; i++ ){
            for (int j=col -1; j< col+2;j++){
                if((i== row && j== col) || i< 0 || j < 0 || i==board.length || j== board[0].length){
                    continue;
                }
                if (board[i][j] == 1 || board[i][j] == 3)
                    neighbours++;
            }
        }

        return neighbours;
    }
}
