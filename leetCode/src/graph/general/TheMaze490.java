package graph.general;

public class TheMaze490 {
    private int m,n;
    private int[][] dirs = new int[][] {{-1,0}, {0,1,}, {1,0}, {0,-1}};
    private int[][] maze;
    private boolean[][] visited;
    private int[] destination;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.maze = maze;
        m = maze.length; n = maze[0].length;
        visited = new boolean[m][n];
        this.destination = destination;
        dfs(start[0], start[1]);
        return visited[destination[0]][destination[1]];

    }

    private void dfs(int i, int j){
        if (visited[i][j]) return;
        visited[i][j] = true;
        if(i == destination[0] && j == destination[1]) return;
        for (int[] dir : dirs){
            int x = i , y = j ;
            while (x + dir[0] > -1 && y + dir[1] > -1 && x+dir[0] < m && y+ dir[1] < n
                    && maze[x+dir[0]][y+dir[1]] == 0){
                x += dir[0];
                y += dir[1];
            }
            dfs(x, y);
        }
    }
}
