package heap;

public class KthLargestElementQS215 {
    int k, n;
    int[] nums;

    public int findKthLargest(int[] nums, int k) {
        this.n = nums.length;
        this.k = n-k;
        this.nums = nums;
        return quickSelect(0, n-1);
    }

    private int quickSelect(int left, int right){
        if (left == right) {
            return nums[left];
        }
        int i = left - 1, j = right + 1;
        int x = nums[(left + right) >>> 1];
        while (i < j) {
            while (nums[++i] < x)
                ;
            while (nums[--j] > x)
                ;
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        if (j < k) {
            return quickSelect( j + 1, right);
        }
        return quickSelect( left, j);
    }

    public static void main(String[] args) {
        KthLargestElementQS215 prog = new KthLargestElementQS215();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 9;
        System.out.println(prog.findKthLargest(nums,k));
    }
}
