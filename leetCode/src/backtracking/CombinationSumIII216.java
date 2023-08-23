package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII216 {


    List<List<Integer>> result;
    List<Integer> temp;
    int k,n;
    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        temp = new ArrayList<>();
        this.k= k; this.n = n;
        dfs(n,1);
        return result;
    }

    private void dfs(int sum, int i){
        if (sum==0 && temp.size()==k)
            result.add(new ArrayList<>(temp));

        if (i > sum || temp.size() > k)
            return;

        for (int j=i;j<10;j++){
            temp.add(j);
            dfs(sum-j,j+1);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        CombinationSumIII216 prog = new CombinationSumIII216();
        System.out.println(prog.combinationSum3(3,15));
    }
}
