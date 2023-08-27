package binarySearch;

public class GuessNumberHigherOrLower374 {
    public int guessNumber(int n) {
        int left=1 , right =n, mid;

        while (left <= right){
            mid = (right + left) >>> 1;
            if (guess(mid) <= 0)
                right = mid -1;
            else
                left = mid +1;
        }
        return left;
    }

    public int guess(Integer i){
        return -i.compareTo(7);
    }

    public static void main(String[] args) {
        GuessNumberHigherOrLower374 prog = new GuessNumberHigherOrLower374();
        System.out.println(prog.guessNumber(30));
    }
}
