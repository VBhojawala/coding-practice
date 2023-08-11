package divideAndConquer;

public class ConvertSortedArrayToBST108 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return dfs(0, nums.length-1);
    }

    private TreeNode dfs(int left, int right){
        if(left > right)
            return null;

        int mid = left + (right -left) / 2 ;
        TreeNode lChild = dfs(left, mid-1);
        TreeNode rChild = dfs(mid+1, right);

        return new TreeNode(nums[mid], lChild, rChild);
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBST108 prog = new ConvertSortedArrayToBST108();
        System.out.println(prog.sortedArrayToBST(new int[]{-10,-3,0,5,9}));

    }

}
