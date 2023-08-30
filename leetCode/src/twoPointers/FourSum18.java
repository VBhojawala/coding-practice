package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum18 {

    List<List<Integer>> result;
    List<Integer> temp;
    int[] nums;
    int n;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        result = new ArrayList<>();
        temp = new ArrayList<>();
        this.nums = nums;
        n = nums.length;
        Arrays.sort(nums);
        kSum(0,4, target);
        return result;
    }

    private void kSum(int i, int k, long target){
        if (k==2){
            int left =i, right=n-1, sum;
            while (left < right){
                sum = nums[left] + nums[right];
                if (sum < target)
                    left++;
                else if (sum > target)
                    right--;
                else{
                    List<Integer> quad = new ArrayList<>(temp);
                    quad.add(nums[left]);
                    quad.add(nums[right]);
                    result.add(quad);
                    left++;
                    while ( left < right && nums[left] == nums[left-1])
                        left++;
                }
            }
            return;
        }

        for (int j=i; j<= n-k; j++){
            if ( j!=i && nums[j] == nums[j-1])
                continue;
            temp.add(nums[j]);
            kSum(j+1, k-1, target - nums[j]);
            temp.remove(temp.size() -1);
        }
    }


    public static void main(String[] args) {
        FourSum18 prog = new FourSum18();
        System.out.println(prog.fourSum(new int[]{1,0,-1,0,-2,2}, 0));
        System.out.println(prog.fourSum(new int[]{2,2,2,2,2}, 8));
    }
}
