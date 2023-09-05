package arrays;

public class FirstMissingPositive41 {

    int[] nums;
    int temp;
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        this.nums = nums;

        for (int i=0;i<n;i++){
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i]-1])
                swap(i, nums[i] -1);
        }

        for (int i=0; i<n;i++){
            if (nums[i] != (i+1))
                return i+1;
        }

        return n+1;
    }

    private void swap(int i, int j){
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        FirstMissingPositive41 prog = new FirstMissingPositive41();
        System.out.println(prog.firstMissingPositive(new int[]{1,2,0}));
        System.out.println(prog.firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(prog.firstMissingPositive(new int[]{7,8,9,11,12}));
    }
}
