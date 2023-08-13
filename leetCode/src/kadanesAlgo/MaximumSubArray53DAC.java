package kadanesAlgo;

public class MaximumSubArray53DAC {

    int[] nums;
    public int maxSubArray(int[] nums) {
        this.nums = nums;
        return maxSubArray(0, nums.length-1);
    }

    private int maxSubArray(int left, int right){
        if(left >= right){
            return nums[left];
        }

        int mid = left + (right - left) / 2;
        int lsum = maxSubArray(left, mid);
        int rsum = maxSubArray(mid+1, right);

        return Math.max(Math.max(lsum, rsum), maxSubArray(left, mid, right));
    }

    private int maxSubArray(int left , int mid, int right){
        int lsum=0, rsum=0;
        int lmax= Integer.MIN_VALUE, rmax=Integer.MIN_VALUE;

        for (int i=mid; i >= left; i--){
            lsum += nums[i];
            lmax = Math.max(lmax,lsum);
        }

        for (int i=mid+1; i <= right; i++){
            rsum += nums[i];
            rmax = Math.max(rmax, rsum);
        }
        return lmax + rmax;
    }

    public static void main(String[] args) {
        MaximumSubArray53DAC prog = new MaximumSubArray53DAC();
        System.out.println(prog.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
