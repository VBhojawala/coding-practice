package twoPointers;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int left =0, right= arr.length-1;

        while ((right - left + 1) > k) {
            if (Math.abs(arr[left] -x) > Math.abs(arr[right] -x))
                left++;
            else
                right--;
        }

        for (int i=left; i<=right;i++)
            result.add(arr[i]);

        return result;
    }
    public static void main(String[] args) {
        FindKClosestElements658 prog = new FindKClosestElements658();
        System.out.println(prog.findClosestElements(new int[]{1,2,3,4,5}, 4,3));
        System.out.println(prog.findClosestElements(new int[]{1,2,3,4,5}, 4,-1));
    }
}
