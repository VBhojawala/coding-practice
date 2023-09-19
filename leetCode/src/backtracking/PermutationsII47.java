package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII47 {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();
    private int[] nums;
    private int n;
    private boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        this.n = nums.length;
        visited = new boolean[n];
        dfs(0);
        return result;
    }

    private void dfs(int i){
        if (i == n){
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int j=0 ; j < n; j++){
            if (visited[j] || (j > 0 && nums[j] == nums[j-1] && !visited[j-1]))
                continue;

            temp.add(nums[j]);
            visited[j] = true;
            dfs(i+1);
            visited[j] = false;
            temp.remove(temp.size() -1);
        }

    }

    public static void main(String[] args) {
        PermutationsII47 prog = new PermutationsII47();
        System.out.println(prog.permuteUnique(new int[]{1,1,2}));
    }
}
