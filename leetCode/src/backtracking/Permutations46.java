package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations46 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    int[] nums;
    boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        visited = new boolean[nums.length];
        dfs(0);
        return result;

    }

    private void dfs(int i){

        if (i == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int j=0;j< nums.length; j++){
            if(!visited[j]){
                visited[j]=true;
                temp.add(nums[j]);
                dfs(i+1);
                temp.remove(temp.size()-1);
                visited[j]=false;
            }
        }
    }

    public static void main(String[] args) {
        Permutations46 prog = new Permutations46();
        System.out.println(prog.permute(new int[]{1,2,3}));
    }
}
