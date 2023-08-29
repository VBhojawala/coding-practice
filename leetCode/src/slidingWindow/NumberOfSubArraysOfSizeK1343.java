package slidingWindow;

public class NumberOfSubArraysOfSizeK1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int total =0, n=arr.length;
        for (int i=0;i<k;i++)
            total += arr[i];

        int result = (total / k) >= threshold ? 1 : 0;

        for (int i=k; i<n; i++){
            total += arr[i] - arr[i-k];
            result += total / k >= threshold ? 1 : 0;
        }

        return result;
    }

    public static void main(String[] args) {
        NumberOfSubArraysOfSizeK1343 prog = new NumberOfSubArraysOfSizeK1343();
        System.out.println(prog.numOfSubarrays(new int[]{2,2,2,2,5,5,5,8}, 3,4));
        System.out.println(prog.numOfSubarrays(new int[]{11,13,17,23,29,31,7,5,2,3}, 3,5));
    }
}
