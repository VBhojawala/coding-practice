package arrays;

public class RemoveDuplicateFromSortedArray26 {

    public static int removeDuplicates(int[] nums) {
        int count =0;
        int previous = nums[0];
        for(int i=1; i <nums.length ; i++){
           if(previous == nums[i]){
               count ++;
           }
           previous=nums[i];
           nums[i-count] = nums[i];
        }
        return nums.length - count;
    }

    public static void main(String[] args) {
        int [] nums = {1,1,2};
        System.out.println("Unique elements : " + removeDuplicates(nums));
        for (int i=0;i < nums.length;i++){
            System.out.print(nums[i] +", ");
        }
    }
}
