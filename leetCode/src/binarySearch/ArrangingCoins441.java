package binarySearch;

public class ArrangingCoins441 {
    public int arrangeCoins(int n) {
        long left = 1, right =n, mid;
        while (left <= right){
            mid = (left + right) >>> 1;
            if ((mid) * (mid +1) /2 <= n)
                left = mid + 1;
            else
                right = mid -1;
        }
        return (int)right;
    }

    public static void main(String[] args) {
        ArrangingCoins441 prog = new ArrangingCoins441();
        System.out.println(prog.arrangeCoins(5));
    }
}
