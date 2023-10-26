package arrays;

public class MovingAverageFromDataStream346 {

    private int[] nums;
    private int sum, count, size;
    public MovingAverageFromDataStream346(int size) {
        this.size = size;
        nums = new int[size];
    }

    public double next(int val) {
        int pos = count % size;
        sum += val - nums[pos];
        nums[pos] = val;
        count++;
        return sum * 1.0 / Math.min(count, size);
    }
}
