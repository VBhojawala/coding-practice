package binarySearch;

public class CapacityToShipPackagesWithinDDays1011 {

    private int[] weight;
    private int days;
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right=0;
        this.weight = weights;
        this.days = days;

        for (int w : weights){
            left = Math.max(left, w);
            right += w;
        }

        while (left < right){
            int mid = left + (right - left) / 2 ;
            if (check(mid)){
                right = mid;
            }else {
                left = mid +1;
            }
        }
        return left;
    }

    private boolean check(int maxWeight){
        int requiredDays = 1, curWeight=0;

        for (int w : weight){
            curWeight += w;
            if (curWeight > maxWeight){
                curWeight = w;
                requiredDays++;
            }
        }
        return requiredDays <= days ;
    }
}
