package graph.general;

public class SurroundedRegions130UF {

    int[] parent;
    public void solve(char[][] board) {
        int m= board.length;
        int n= board[0].length;

        parent = new int[n * m +1];

        for (int i=0; i< parent.length; i++)
            parent[i] = i;


        for (int i=0; i < m; i++){
            for (int j=0; j< n; j++){
                if(board[i][j] == 'O'){
                    if((i == 0 || j ==0 || i == m-1 || j == n-1)){
                        parent[find(i*n +j)] = find(m *n);
                    }else {
                        if (board[i+1][j] == 'O') parent[find((i+1) * n + j)] = find(i*n +j);
                        if (board[i-1][j] == 'O') parent[find((i-1) * n+ j)] = find(i*n +j);
                        if (board[i][j+1] == 'O') parent[find(i * n + (j+1))] = find(i*n +j);
                        if (board[i][j-1] == 'O') parent[find(i * n + (j-1))] = find(i*n +j);
                    }
                }

            }
        }

        for (int i=0; i< m; i++){
            for (int j=0; j< n; j++){
                if(board[i][j] == 'O' && find(i*n +j) != find(n*m))
                    board[i][j] = 'X';
            }
        }
    }

    private int find(int x){
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }


    public static void main(String[] args) {
        SurroundedRegions130UF prog = new SurroundedRegions130UF();
        char[][] board = {
                {'X','O','O','X','X','X','O','X','O','O'},
                {'X','O','X','X','X','X','X','X','X','X'},
                {'X','X','X','X','O','X','X','X','X','X'},
                {'X','O','X','X','X','O','X','X','X','O'},
                {'O','X','X','X','O','X','O','X','O','X'},
                {'X','X','O','X','X','O','O','X','X','X'},
                {'O','X','X','O','O','X','O','X','X','O'},
                {'O','X','X','X','X','X','O','X','X','X'},
                {'X','O','O','X','X','O','X','X','O','O'},
                {'X','X','X','O','O','X','O','X','X','O'}};

        prog.solve(board);

        for (int i=0; i< board.length; i++){
            for (int j=0; j< board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }
}
