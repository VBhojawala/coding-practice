package stack.monotonic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i=nums2.length-1; i>=0; i--){
            while (!stack.isEmpty() && stack.peek() < nums2[i])
                stack.pop();
            if (!stack.isEmpty())
                map.put(nums2[i], stack.peek());
            stack.push(nums2[i]);
        }

        int [] result = new int[nums1.length];
        for (int i=0;i<nums1.length; i++){
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }

    public static void main(String[] args) {
        NextGreaterElement496 prog = new NextGreaterElement496();
        Arrays.stream(prog.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})).forEach(System.out::println);
        Arrays.stream(prog.nextGreaterElement(new int[]{2,4}, new int[]{1,2,3,4})).forEach(System.out::println);
    }
}
