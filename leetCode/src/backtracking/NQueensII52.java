package backtracking;

import java.util.HashSet;
import java.util.Set;

public class NQueensII52 {

    Set<Integer> cols = new HashSet<>();
    Set<Integer> posDiagonal = new HashSet<>();
    Set<Integer> negDiagonal = new HashSet<>();
    int n, result=0;


    public int totalNQueens(int n) {
        this.n = n;
        backtrack(0);
        return result;
    }

    private void backtrack(int r) {
        if (r == n) {
            result++;
            return;
        }

        for (int c = 0; c < n; c++) {
            if (!cols.contains(c) && !posDiagonal.contains(r + c) && !negDiagonal.contains(r - c)) {
                cols.add(c);
                posDiagonal.add(r + c);
                negDiagonal.add(r - c);

                backtrack(r + 1);

                cols.remove(c);
                posDiagonal.remove(r + c);
                negDiagonal.remove(r - c);
            }
        }
    }

    public static void main(String[] args) {
        NQueensII52 prog = new NQueensII52();
        System.out.println(" NQueens(4) : "+ prog.totalNQueens(4));
    }
}
