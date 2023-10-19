package arrays;

public class MaxConsecutiveOnes485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int count =0, maxCount=0;
        for (int i=0; i<n; i++){
            if (nums[i] == 1){
                count =0;
                while (i < n && nums[i] == 1){
                    i++;
                    count++;
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return  maxCount;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes485 prog = new MaxConsecutiveOnes485();
        System.out.println(prog.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
        System.out.println(prog.findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));
    }
}
