package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {

    List<List<Integer>> result;
    List<Integer> temp;
    int[] nums;
    int n;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        n = nums.length;
        result = new ArrayList<>();
        temp = new ArrayList<>();
        dfs(0);
        return result;
    }

    private void dfs(int i){
        if (i>=n){
            result.add(new ArrayList<>(temp));
            return;
        }

        dfs(i+1);
        temp.add(nums[i]);
        dfs(i+1);
        temp.remove(temp.size() -1 );
    }

    public static void main(String[] args) {
        Subsets78 prog = new Subsets78();
        System.out.println(prog.subsets(new int[]{1,2,3}));
    }

}
