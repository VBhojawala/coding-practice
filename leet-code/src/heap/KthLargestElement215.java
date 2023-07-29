package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement215 {
    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());

        for (int i=0; i < nums.length; i++){
            pq.add(nums[i]);
        }
        for (int i=0; i< k-1 ;i++){
            pq.remove();
        }
        return pq.remove();
    }

    public static void main(String[] args) {

        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;

        System.out.println(findKthLargest(nums, k));

    }
}
