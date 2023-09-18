package binarySearch;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n= spells.length, m= potions.length;
        int[] result = new int[n];
        int left,right, mid;
        for (int i=0;i<n;i++){
            left =0; right=m;
            while (left < right){
                mid = (left +right) >> 1;
                if ((long) spells[i] * potions[mid] >= success)
                    right = mid;
                else
                    left = mid + 1;
            }
            result[i] = m -left;
        }
        return result;
    }
}
