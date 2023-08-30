package twoPointers;

import java.util.Arrays;

public class ArrayWithElementsNotEqualToAverageNeighbour1968 {
    public int[] rearrangeArray(int[] nums) {
        int n= nums.length;
        int[] result = new int[n];
        int left=0, right = n-1, cur=0;

        Arrays.sort(nums);

        while (cur < n){
            result[cur++] = nums[left++];
            if (left <= right)
                result[cur++] = nums[right--];
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayWithElementsNotEqualToAverageNeighbour1968 prog =new ArrayWithElementsNotEqualToAverageNeighbour1968();
        Arrays.stream(prog.rearrangeArray(new int[]{1,2,3,4,5})).forEach(System.out:: println);
    }
}
