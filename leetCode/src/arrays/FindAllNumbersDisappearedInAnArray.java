package arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length, index;

        for (int num : nums){
            index = Math.abs(num) -1;
            if (nums[index] > 0)
                nums[index] *= -1;
        }

        for (int i=0 ;i<n;i++){
            if (nums[i] > 0)
                result.add(i+1);
        }

        return result;
    }
}
