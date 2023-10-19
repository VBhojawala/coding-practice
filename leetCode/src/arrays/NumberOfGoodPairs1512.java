package arrays;

public class NumberOfGoodPairs1512 {
    public int numIdenticalPairs(int[] nums) {
        int pairsCount=0;
        int[] count = new int[101];
        for (int num : nums){
            pairsCount += count[num]++;
        }
        return pairsCount;
    }
}
