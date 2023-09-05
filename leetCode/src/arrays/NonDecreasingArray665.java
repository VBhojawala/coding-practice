package arrays;

public class NonDecreasingArray665 {
    public boolean checkPossibility(int[] nums) {
        boolean isReplaceAvailable = true;

        if (nums.length <= 2) return true;

        if (nums[0] > nums[1]){
            nums[0] = nums[1];
            isReplaceAvailable = false;
        }

        for (int i=2; i<nums.length; i++){
            if (nums[i] < nums[i-1]){
                if (!isReplaceAvailable)
                    return false;
                else if (nums[i-2] <= nums[i])
                    nums[i-1] = nums[i];
                else
                    nums[i] = nums[i-1];
                isReplaceAvailable= false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NonDecreasingArray665 prog = new NonDecreasingArray665();
        System.out.println(prog.checkPossibility(new int[]{5,7,1,8}));
        System.out.println(prog.checkPossibility(new int[]{4,2,3}));
        System.out.println(prog.checkPossibility(new int[]{4,2,1}));
    }
}
