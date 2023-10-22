package binarySearch;

public class MissingNumberInArithmeticProgression1228 {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int difference = (arr[n-1] - arr[0]) / n;
        int left=0, right= n-1;

        while (left < right){
            int mid = left + (right - left) / 2 ;

            if (arr[mid] == arr[0] + mid * difference)
                left = mid +1 ;
            else
                right = mid;

        }
        return arr[0] + difference * left;
    }
}
