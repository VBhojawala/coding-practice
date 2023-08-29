package arrays.prefixSum;

public class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int total = 0, max = 0;
        for (int g : gain){
            total += g;
            max = Math.max(max, total);
        }
        return max;
    }
}
