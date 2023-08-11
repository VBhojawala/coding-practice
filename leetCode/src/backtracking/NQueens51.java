package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens51 {

    Set<Integer> cols = new HashSet<>();
    Set<Integer> posDiagonal = new HashSet<>();
    Set<Integer> negDiagonal = new HashSet<>();

    List<List<String>> result = new ArrayList<>();
    List<String> board = new ArrayList<>();
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        StringBuilder init = new StringBuilder();


        for (int i=0; i<n; i++) init.append(".");
        for (int i=0; i<n; i++) board.add(init.toString());

        backtrack(0);

        return result;
    }
    private void backtrack(int r){
        if (r==n){
            result.add(new ArrayList<>(board));
            return;
        }

        for (int c=0; c<n; c++){
            if ( !cols.contains(c) && !posDiagonal.contains(r+c) && !negDiagonal.contains(r-c)){
                cols.add(c);
                posDiagonal.add(r+c);
                negDiagonal.add(r-c);
                board.set(r, board.get(r).substring(0,c)+"Q"+board.get(r).substring(c+1));

                backtrack(r+1);

                cols.remove(c);
                posDiagonal.remove(r+c);
                negDiagonal.remove(r-c);
                board.set(r, board.get(r).substring(0,c)+"."+board.get(r).substring(c+1));
            }
        }
    }

    public static void main(String[] args) {
        NQueens51 prog = new NQueens51();
        System.out.println(prog.solveNQueens(4));
    }
}
