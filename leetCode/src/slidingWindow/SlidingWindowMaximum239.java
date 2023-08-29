package slidingWindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];

        Deque<Integer> queue = new LinkedList<>();
        int left =0, right=0;
        while (right < n){

            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[right])
                queue.pollLast();

            queue.add(right);

            if (left >  queue.peek())
                queue.poll();

            if (right+1 >= k)
                result[left++] = nums[queue.peek()];

            right++;

        }
        return result;

    }

    public static void main(String[] args) {
        SlidingWindowMaximum239 prog = new SlidingWindowMaximum239();
        Arrays.stream(prog.maxSlidingWindow(new int[]{1,-1}, 1)).forEach(System.out::println);
        Arrays.stream(prog.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)).forEach(System.out::println);
    }
}
