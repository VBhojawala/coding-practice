package math;

public class FactorialTrailingZeros172 {
    public int trailingZeroes(int n) {
        int count=0;
        while (n > 0){
            n /= 5;
            count += n;
        }
        return count;
    }
}
