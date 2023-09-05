package arrays;

public class NumberOfZeroFilledSubArrays2348 {

    public long zeroFilledSubarray(int[] nums) {
        int count=0;
        long ans=0;

        for (int num : nums){
            count = num == 0 ? ++count : 0;
            ans += count;
        }

        return ans;
    }

    public static void main(String[] args) {
        NumberOfZeroFilledSubArrays2348 prog = new NumberOfZeroFilledSubArrays2348();
        System.out.println(prog.zeroFilledSubarray(new int[]{1,3,0,0,2,0,0,4}));
        System.out.println(prog.zeroFilledSubarray(new int[]{0,0,0,2,0,0}));
        System.out.println(prog.zeroFilledSubarray(new int[]{2,10,2019}));
    }
}
