package bitManipulation;

import java.util.HashMap;
import java.util.Map;

public class CinemaSeatAllocation1386 {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> bookings = new HashMap<>();
        for (int[] seat : reservedSeats){
            bookings.merge(seat[0], 1 << (10- seat[1]), (x,y)-> x | y);
        }
        int[] masks = new int[]{0b0111100000,0b0000011110,0b0001111000};
        int count = (n-bookings.size()) * 2;
        for (int x : bookings.values()){
            for (int mask : masks){
                if ((x & mask) == 0){
                    x |= mask;
                    count++;
                }
            }
        }
        return count;
    }
}
