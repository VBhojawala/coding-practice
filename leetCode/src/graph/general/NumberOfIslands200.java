package graph.general;

public class NumberOfIslands200 {
    int m,n;
    char[][] grid;
    public int numIslands(char[][] grid) {
       m = grid.length;
       n = grid[0].length;
       this.grid = grid;
       int count =0;
       for (int i=0; i< m; i++){
           for (int j=0; j<n; j++){
               if (grid[i][j] == '1'){
                   dfs(i,j);
                   count++;
               }
           }
       }
       return count;
    }

    private void dfs(int i, int j){

        if (i < 0 || j < 0 || i >=m || j>=n || grid[i][j] == '0') return;

        grid[i][j] = '0';

        dfs(i+1,j);dfs(i-1,j);
        dfs(i,j+1);dfs(i,j-1);

    }

    public static void main(String[] args) {
        NumberOfIslands200 prog = new NumberOfIslands200();
        char[][] grid = {
          {'1','1','1','1','0'},
          {'1','1','0','1','0'},
          {'1','1','0','0','0'},
          {'0','0','0','0','0'}
        };

        System.out.println(prog.numIslands(grid));
    }


}
