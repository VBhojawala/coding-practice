package binarySearch;

public class BinarySearchVariants {

    int[] nums;

    private void setNums(int[] nums){
        this.nums = nums;
    }
    private int binarySearchIndexLeft(int x){
        int left = 0, right = nums.length -1, mid;

        while (left < right){
            mid = left + (right - left) /  2;
            if (nums[mid] > x)
                right= mid;
            else
                left = mid+1;
        }
        return left;
    }

    private int binarySearchIndexRight(int x){
        int left = 0, right = nums.length -1, mid;

        while (left < right){
            mid = left + (right - left) /  2;
            if (nums[mid] >= x)
                right= mid;
            else
                left = mid+1;
        }
        return left;
    }

    public static void main(String[] args) {
        BinarySearchVariants prog = new BinarySearchVariants();
        prog.setNums(new int[]{1,2,7,7,7,7,7,7,7,8});

        System.out.println("Index Left : "+ prog.binarySearchIndexLeft(7));
        System.out.println("Index Left : "+ prog.binarySearchIndexRight(7));

    }

}
