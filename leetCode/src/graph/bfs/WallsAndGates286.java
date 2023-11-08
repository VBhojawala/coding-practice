package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates286 {


    public class Room{
        int row;
        int col;

        private Room( int row, int col){
            this.row= row;
            this.col = col;
        }
    }
    private Queue<Room> queue;
    public void wallsAndGates(int[][] rooms) {
        queue = new LinkedList<>();
        int m= rooms.length, n= rooms[0].length;

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (rooms[i][j] == 0)
                    queue.offer(new Room(i,j));
            }
        }

        int[][] c = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
        int x,y;
        int distance=0;

        while (!queue.isEmpty()){
            distance++;

            for (int i= queue.size();i>0;i--){
                Room cur = queue.poll();
                for (int[] cc : c){
                    x = cur.row + cc[0];
                    y= cur.col + cc[1];

                    if(x < m && y <n && x >=0 && y >=0 && rooms[x][y] == Integer.MAX_VALUE){
                        rooms[x][y] = distance;
                        queue.offer(new Room(x,y));
                    }
            }
            }
        }
    }

    public static void main(String[] args) {
        WallsAndGates286 prog = new WallsAndGates286();
        int[][] rooms = new int[][]{
                {2147483647,-1,0,2147483647},
                {2147483647,2147483647,2147483647,-1},
                {2147483647,-1,2147483647,-1},
                {0,-1,2147483647,2147483647}};

        prog.wallsAndGates(rooms);
        //[[3,-1,0,1]
        // [2,2,1,-1]
        // [1,-1,2,-1]
        // [0,-1,3,4]]
        for (int i=0;i<rooms.length;i++){
            for (int j=0; j<rooms[0].length;j++){
                System.out.print(rooms[i][j] +" ");
            }
            System.out.println("");
        }

    }
}
