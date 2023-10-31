package arrays;

public class RemovingMinimumElementFromArray2091 {
    public int minimumDeletions(int[] nums) {
        int minIndex = 0, maxIndex = 0, n = nums.length;

        for (int i=1; i<n; i++){
            if (nums[i] < nums[minIndex])
                minIndex = i;
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }

        int temp;
        if (minIndex > maxIndex){
            temp = minIndex;
            minIndex = maxIndex;
            maxIndex = temp;
        }

        return Math.min(Math.min(maxIndex +1, n-minIndex),minIndex+1 + n-maxIndex);

    }

    public static void main(String[] args) {
        RemovingMinimumElementFromArray2091 prog = new RemovingMinimumElementFromArray2091();
        System.out.println(prog.minimumDeletions(new int[]{2,10,7,5,4,1,8,6}));
        System.out.println(prog.minimumDeletions(new int[]{0,-4,19,1,8,-2,-3,5}));
        System.out.println(prog.minimumDeletions(new int[]{101}));
    }
}
