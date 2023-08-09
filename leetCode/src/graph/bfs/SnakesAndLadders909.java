package graph.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class SnakesAndLadders909 {
    int n;
    public int snakesAndLadders(int[][] board) {
        n = board.length;
        int moves =0;

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n*n+1];
        visited[1] = true;
        queue.offer(1);

        while (!queue.isEmpty()){
            for (int l= queue.size();l>0; l--){
                int curr = queue.poll();
                if (curr == n*n)
                    return moves;
                for (int k = curr +1 ; k <= Math.min(curr+6, n*n); k++){
                    int[] xy = getPos(k);
                    int next = k;
                    if (board[xy[0]][xy[1]] != -1){
                        next= board[xy[0]][xy[1]];
                    }
                    if(!visited[next]){
                        queue.offer(next);
                        visited[next]=true;
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    private int[] getPos(int x){
        int i = (x-1) / n, j = (x-1) % n;
        if(i % 2 == 1){
            j = n-1-j;
        }
        return new int[]{n-1-i, j};
    }

    public static void main(String[] args) {
        SnakesAndLadders909 prog = new SnakesAndLadders909();
        int[][] board = {
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}};

        System.out.println("Moves : " + prog.snakesAndLadders(board));

    }
}
