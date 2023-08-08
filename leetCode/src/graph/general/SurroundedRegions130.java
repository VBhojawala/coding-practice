package graph.general;

public class SurroundedRegions130 {
    int m,n;
    char[][] board;
    public void solve(char[][] board) {
        m= board.length;
        n= board[0].length;
        this.board = board;

        for (int i=0; i < m; i++){
            for (int j=0; j< n; j++){
                if((i == 0 || j ==0 || i == m-1 || j == n-1) && board[i][j] == 'O'){
                    dfs(i,j);
                }
            }
        }

        for (int i=0; i< m; i++){
            for (int j=0; j< n; j++){
                if (board[i][j] == '.')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }
    }

    private void dfs(int i,int j){

        if(i < 0 || j < 0 || i>= m || j >=n || board[i][j] != 'O') return;

        board[i][j] = '.';

        dfs(i+1,j);dfs(i-1,j);
        dfs(i,j+1);dfs(i,j-1);

    }

    public static void main(String[] args) {
        SurroundedRegions130 prog = new SurroundedRegions130();
        char[][] board = {
                {'X','X','X','O'},
                {'X','O','O','X'},
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','O','X','X'}};

        prog.solve(board);

        for (int i=0; i< board.length; i++){
            for (int j=0; j< board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }
}
