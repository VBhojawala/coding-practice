package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumSubSequenceScore2542 {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] nums = new int[n][2];

        for (int i=0; i<n ; i++)
            nums[i] = new int[]{nums1[i], nums2[i]};

        Arrays.sort(nums, (a, b) -> b[1] - a[1]);

        PriorityQueue<Integer> heap= new PriorityQueue<>();
        long max=0, sum =0;

        for (int i=0;i<n;i++){
            sum += nums[i][0];
            heap.offer(nums[i][0]);

            if (heap.size() == k){
                max = Math.max(max, sum * nums[i][1]);
                sum -= heap.poll();
            }
        }

        return max;
    }
}
