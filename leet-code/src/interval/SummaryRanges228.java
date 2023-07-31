package interval;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges228 {

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int left;

        for(int right=0; right<nums.length;){
            left = right;

            while (right +1 < nums.length && nums[right] + 1 == nums[right +1] ){
                right++;
            }

            if(right == left){
                result.add(String.valueOf(nums[right]));
                right = right+1;
            }
            else{
                result.add(String.format("%d->%d", nums[left], nums[right]));
                right = right+1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        System.out.println(summaryRanges(nums));

    }
}
