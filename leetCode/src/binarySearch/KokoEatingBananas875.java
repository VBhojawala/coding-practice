package binarySearch;

import java.util.stream.IntStream;

public class KokoEatingBananas875 {
    public int minEatingSpeed(int[] piles, int h) {
        int left =1, right = IntStream.of(piles).max().getAsInt();
        int mid, k;
        while (left < right){
            mid = (left + right) >>> 1;
            k = 0;
            for (int pile : piles)
                k += (pile + mid -1) / mid;

            if (k <= h)
                right = mid;
            else
                left = mid+1;
        }
        return left;
    }

    public static void main(String[] args) {
        KokoEatingBananas875 prog = new KokoEatingBananas875();
        System.out.println(prog.minEatingSpeed(new int[]{3,6,7,11}, 8));
        System.out.println(prog.minEatingSpeed(new int[]{30,11,23,4,20}, 5));
        System.out.println(prog.minEatingSpeed(new int[]{30,11,23,4,20}, 6));
    }
}
