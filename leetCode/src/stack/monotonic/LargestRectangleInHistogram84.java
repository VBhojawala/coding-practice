package stack.monotonic;

import java.util.Stack;

public class LargestRectangleInHistogram84 {

    public class Rectangle{
        int height;
        int index;

        public Rectangle(int height, int index){
            this.height = height;
            this.index = index;
        }
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Rectangle> stack = new Stack<>();
        int maxArea = 0, start;

        for (int i=0; i< heights.length; i++){
            start =i;
            while (!stack.isEmpty() && stack.peek().height > heights[i]){
                Rectangle r = stack.pop();
                maxArea = Math.max(maxArea, r.height * (i - r.index));
                start = r.index;
            }
            stack.push(new Rectangle(heights[i], start));
        }

        while (!stack.isEmpty()){
            Rectangle r = stack.pop();
            maxArea = Math.max(maxArea, r.height * (heights.length - r.index));
        }

        return maxArea;

    }

    public static void main(String[] args) {
        LargestRectangleInHistogram84 prog = new LargestRectangleInHistogram84();
        System.out.println(prog.largestRectangleArea(new int[]{2,1,2}));
        System.out.println(prog.largestRectangleArea(new int[]{2,4}));
    }
}
