package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetII90 {

    List<List<Integer>> result;
    int[] nums;
    int n;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        n = nums.length;
        result = new ArrayList<>();
        dfs(0, new ArrayList<>());
        return result;

    }
    private void  dfs(int i, List<Integer> temp){
        result.add(new ArrayList<>(temp));
        for (int j=i; j<n;j++){
            if (i!=j && nums[j]== nums[j-1])
                continue;
            temp.add(nums[j]);
            dfs(j+1, temp);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        SubSetII90 prog = new SubSetII90();
        System.out.println(prog.subsetsWithDup(new int[]{1,2,2}));
    }
}
