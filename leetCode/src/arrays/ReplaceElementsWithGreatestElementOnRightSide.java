package arrays;

import java.util.Arrays;

public class ReplaceElementsWithGreatestElementOnRightSide {
    public int[] replaceElements(int[] arr) {
        int rightMax = -1, n= arr.length, temp;
        for (int i=n-1; i>=0 ; i--){
            temp = arr[i];
            arr[i] = rightMax;
            rightMax = Math.max(temp, arr[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        ReplaceElementsWithGreatestElementOnRightSide prog = new ReplaceElementsWithGreatestElementOnRightSide();
        Arrays.stream(prog.replaceElements(new int[]{17,18,5,4,6,1})).forEach(System.out::println);
        System.out.println();
        Arrays.stream(prog.replaceElements(new int[]{400})).forEach(System.out::println);

    }
}
