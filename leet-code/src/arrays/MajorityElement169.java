package arrays;

public class MajorityElement169 {
    public static int majorityElement(int[] nums) {
        int curMajority = nums[0];
        int count = 1;

        for (int i=1; i <nums.length; i++){
            if(nums[i] == curMajority){
                count++;
            }else {
                if(count == 0){
                    curMajority = nums[i];
                }else {
                    count--;
                }
            }
        }
        return curMajority;
    }
    public static void main(String[] args) {
        int[] nums = {10,9,9,9,10};
        System.out.println("Majority Element : "+ majorityElement(nums));
    }
}
