package math;

public class PalindromeNumber9 {

    public static boolean isPalindrome(long x) {

        if (x < 0)
            return false;

        long division = 1;

        while ( x >= division * 10){
            division *= 10;
        }

        long left, right;

        while (x > 0){
            left = x / division;
            right = x % 10;

            if(left != right)
                return false;

            x = ( x % division ) / 10;
            division /= 100;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1410110141));
    }
}
