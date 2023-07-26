package twoPointers;

public class ContainerWithMostWater11 {

    public static int maxArea(int[] height) {
        int max = 0;
        int cur = 0;
        int front =0;
        int rear = height.length -1;

        while (front < rear){
            cur = Math.min(height[front], height[rear]) * (rear-front);
            if(cur > max){
                max = cur;
            }
            if(height[front] < height[rear]){
                front ++;
            }else {
                rear --;
            }
        }
        return max;
    }
    public static void main(String[] args) {

        int[] array = {1,1};
        System.out.println("Max area : " + maxArea(array));

    }
}
