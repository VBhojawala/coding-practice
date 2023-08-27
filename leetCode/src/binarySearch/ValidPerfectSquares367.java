package binarySearch;

public class ValidPerfectSquares367 {
    public boolean isPerfectSquare(int num) {
        long left = 0, right=num, mid=0;

        while (left <= right){
            mid = (left + right) >>> 1;
            if ((mid*mid) <= num)
                left = mid + 1;
            else
                right = mid -1;
        }
        return (right * right) == num;
    }

    public static void main(String[] args) {
        ValidPerfectSquares367 prog = new ValidPerfectSquares367();
        System.out.println(prog.isPerfectSquare(16));
        System.out.println(prog.isPerfectSquare(11));
        System.out.println(prog.isPerfectSquare(25));
        System.out.println(prog.isPerfectSquare(99));
    }
}
