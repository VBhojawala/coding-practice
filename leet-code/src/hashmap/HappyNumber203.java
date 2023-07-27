package hashmap;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber203 {
    public static boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();

        while (!visited.contains(n)){
            visited.add(n);
            n = sumOfSquareOfDigits(n);
            if(n==1)
                return true;
        }

        return false;
    }

    private static int sumOfSquareOfDigits(int n){
        int sum =0;
        while (n !=0){
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }


    public static void main(String[] args) {
        int n=19;
        System.out.println("Is Happy Number : "+ isHappy(n));
    }
}
