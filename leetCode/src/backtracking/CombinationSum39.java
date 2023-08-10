package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum39 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    int[] candidates ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        dfs(0, target);
        return result;
    }

    private void dfs(int i, int sum){
        if(sum == 0){
            result.add(new ArrayList<>(temp));
            return;
        }
        if (sum < candidates[i])
            return;

        for (int j=i;j<candidates.length; j++){
            temp.add(candidates[j]);
            dfs(j, sum-candidates[j]);
            temp.remove(temp.size() -1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;

        CombinationSum39 prog = new CombinationSum39();
        System.out.println(prog.combinationSum(candidates, target));

    }
}
