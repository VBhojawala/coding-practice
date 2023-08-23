package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII40 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    int n;
    int[] candidates;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        n= candidates.length;
        dfs(target, 0);
        return result;

    }

    private void dfs(int sum, int i){
        if (sum == 0){
            result.add(new ArrayList<>(temp));
            return;
        }

        if (i >=n || candidates[i] > sum )
            return;

        for (int j=i; j<n;j++){
            if (j!=i && candidates[j] == candidates[j-1])
                continue;
            temp.add(candidates[j]);
            dfs(sum-candidates[j],j+1);
            temp.remove(temp.size() -1);
        }
    }

    public static void main(String[] args) {
        CombinationSumII40 prog = new CombinationSumII40();
        System.out.println(prog.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }

}
