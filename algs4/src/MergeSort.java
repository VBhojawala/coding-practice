import java.util.Arrays;

public class MergeSort {

    static void  merge(int[]  a, int[] aux, int low, int mid, int high){
        for (int k=low; k <= high; k++){
            aux[k] = a[k];
        }

        int left=low, right= mid +1;
        for (int k= low; k <= high; k++){
            if (left > mid) a[k] = aux[right++];
            else if (right > high) a[k] = aux[left++];
            else if (aux[left] < aux[right]) a[k] = aux[left++];
            else  a[k] = aux[right++];
        }
    }

    static void sort(int[] a){
        int[] aux = new int[a.length];
        sort(a, aux, 0, a.length -1);
    }
    static  void sort(int[] a , int aux[], int low, int high){
        if(high <= low ) return;
        int mid = low + (high -low ) / 2 ;

        sort(a, aux, low, mid);
        sort(a, aux, mid + 1, high);
        merge(a, aux, low, mid, high);

    }

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        sort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
