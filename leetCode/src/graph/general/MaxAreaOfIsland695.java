package graph.general;

public class MaxAreaOfIsland695 {

    int m,n;
    int[][] grid;

    int[][] rc = new int[][] {{0,1}, {1,0}, {-1,0}, {0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        m= grid.length; n = grid[0].length;
        int max=0;

        for (int i=0;i<m;i++){
            for (int j=0; j<n;j++){
                if (grid[i][j] == 1){
                    max = Math.max(max, dfs(i, j));
                }
            }
        }
        return max;
    }

    private int dfs(int x, int y){
        int area = 1;
        grid[x][y] = 0;
        for (int[] cc : rc){
            int i = x + cc[0];
            int j = y + cc[1];
            if (i>=0 && j >=0 && i<m && j<n && grid[i][j] == 1)
                area += dfs(i,j);
        }
        return area;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        MaxAreaOfIsland695 prog = new MaxAreaOfIsland695();
        System.out.println(prog.maxAreaOfIsland(grid));
    }
}
