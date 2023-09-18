package dynamicProgramming.oneDimensional;

public class NthTribonacciNumber1137 {
    public int tribonacci(int n) {
        int a=0, b=1, c=1, d;
        while (n-- > 0){
            d = a + b +c;
            a = b;
            b = c;
            c = d;
        }
        return a;
    }
}
