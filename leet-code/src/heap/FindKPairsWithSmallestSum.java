package heap;

import java.util.*;

class Sum{
    int sum;
    int i;
    int j;

    public Sum(int sum, int i, int j) {
        this.sum = sum;
        this.i = i;
        this.j = j;
    }


}
public class FindKPairsWithSmallestSum {
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<Sum> minPq = new PriorityQueue<>(Comparator.comparingInt(s->s.sum));
        List<List<Integer>> result = new LinkedList<>();

        for (int i=0; i< Math.min(nums1.length, k); i++){
            minPq.add(new Sum(nums1[i] + nums2[0], i, 0));
        }

        while (!minPq.isEmpty() && k > 0){
            Sum sum = minPq.poll();
            result.add(Arrays.asList(nums1[sum.i], nums2[sum.j]));

            k--;

            if(sum.j +1 < nums2.length){
               minPq.add(new Sum(nums1[sum.i] + nums2[sum.j +1],sum.i, sum.j +1));
            }

        }

        return  result;
    }

    public static void main(String[] args) {

        int[] nums1 = {1,7,11}, nums2 = {2,4,6};
        int k = 3;
        System.out.println(kSmallestPairs(nums1, nums2, k));

    }
}
