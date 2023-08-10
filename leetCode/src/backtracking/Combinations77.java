package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations77 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    int n, k;
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        dfs(1);
        return result;
    }
    private void dfs(int i){
        if(temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (i > n)
            return;

        for (int j=i; j <=n; j++){
            temp.add(j);
            dfs(j+1);
            temp.remove(temp.size() -1);
        }
    }

    public static void main(String[] args) {
        Combinations77 prog = new Combinations77();
        System.out.println(prog.combine(4, 2));
    }
}
