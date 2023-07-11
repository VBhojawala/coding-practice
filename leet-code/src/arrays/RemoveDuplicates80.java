package arrays;

public class RemoveDuplicates80 {
    public static int removeDuplicates(int[] nums) {
        int count=0;
        int previous= nums[0];
        for(int i=2; i< nums.length;i++){

            if(nums[i] == previous){
                count++;
            }
            previous = nums[i-1];
            nums[i-count] = nums[i];
        }
        return nums.length - count;
    }

    public static void main(String[] args) {
        int nums[] = {1,1,1,2,2,3};

        System.out.println("No of Elements : " + removeDuplicates(nums));

        for (int i=0;i < nums.length;i++){
            System.out.print(nums[i] +", ");
        }
    }
}
