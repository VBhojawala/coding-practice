import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSort {

    private static void sort(int[] a){
        // shuffle Array element
        sort(a, 0, a.length -1);
    }

    private static void sort(int[] a, int low, int high){
        if (high <= low) return;
        int partitionIndex = partition(a, low ,high);
        sort(a, low, partitionIndex-1);
        sort(a, partitionIndex + 1, high);
    }

    private static int partition(int[] a, int low, int high){
        int left = low;
        int right = high+1;

        while (true){

            while (a[++left] < a[low]){
                if (left == high) break;
            }

            while (a[--right] > a[low]){
                if (right == low) break;
            }

            if (left >= right) break;

            exch(a, left, right);

        }

        exch(a, low, right);

        return right;
    }

    private static void exch(int[] a, int i, int j){
           int temp = a[i];
           a[i] = a[j];
           a[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        sort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
