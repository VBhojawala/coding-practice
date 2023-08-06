package arrays;

public class RemoveElement27 {

    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for(int i=0; i < nums.length; i++){
            if(nums[i] == val){
                count ++;
            }else {
                nums[i-count] = nums[i];
            }

        }
        return nums.length - count;
    }

    public static void main(String[] args) {
        int nums[] = {3,2,2,5,4,2,3,2,3};
        System.out.println("No of Elements : " + removeElement(nums, 3));
        for (int i=0;i < nums.length;i++){
            System.out.print(nums[i] +", ");
        }
    }
}
