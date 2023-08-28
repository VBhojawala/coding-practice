package stack.monotonic;

import java.util.Stack;

public class DailyTemperatures739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i=0;i<n;i++){
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int j = stack.pop();
                result[j] = i-j;
            }
            stack.push(i);
        }
        return result;
    }
}
