package math;

public class SqrtX69 {
    public static int mySqrt(int x) {
        int left =0, right =x, mid;
        while (left < right){
            mid = ( left + right + 1) >>> 1;
            if ( mid <= x/mid)
                left = mid;
            else
                right = mid-1;
        }
        return  left;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }
}
