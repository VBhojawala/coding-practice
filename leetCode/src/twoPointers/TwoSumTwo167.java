package twoPointers;

import java.util.Arrays;

public class TwoSumTwo167 {

    public static int[] twoSum(int[] numbers, int target) {
       int front =0;
       int rear = numbers.length -1;

       while (front < rear){
           if(numbers[front] + numbers[rear] == target){
               return new int[]{front + 1, rear + 1};
           }
           else if(numbers[front] + numbers[rear] > target){
               rear --;
           }
           else {
               front++;
           }
       }
       return null;
    }

    public static void main(String[] args) {

        int[] numbers = {-1,0};
        System.out.println("Two Sum : ");
        Arrays.stream(twoSum(numbers, -1)).forEach(System.out::println);

    }
}
