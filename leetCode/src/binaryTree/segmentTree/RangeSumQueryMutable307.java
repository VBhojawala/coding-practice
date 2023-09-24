package binaryTree.segmentTree;

public class RangeSumQueryMutable307 {
    int[] nums;
    int[] binaryIndexedTree;
    int n;
    public RangeSumQueryMutable307(int[] nums) {
        this.nums = nums;
        n = nums.length;
        binaryIndexedTree = new int[n+1];
        for (int i=0;i<n;i++){
            init(i+1, nums[i]);
        }

    }
    public void init(int i, int val){
        while (i <= n){
            binaryIndexedTree[i] += val;
            i += (i & -i);
        }
    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        init( index+1, diff);
    }

    public  int getSum(int i){
        int sum = 0;
        while (i > 0){
            sum += binaryIndexedTree[i];
            i -= (i & -i);
        }
        return sum;
    }
    public int sumRange(int left, int right) {
        return getSum(right+1) - getSum(left);
    }

    public static void main(String[] args) {
        RangeSumQueryMutable307 prog = new RangeSumQueryMutable307(new int[]{1,3,5});
        System.out.println(prog.sumRange(0,2));
        prog.update(1,2);
        System.out.println(prog.sumRange(0,2));
    }
}
