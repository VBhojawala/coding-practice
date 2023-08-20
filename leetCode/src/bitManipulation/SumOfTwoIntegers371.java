package bitManipulation;

public class SumOfTwoIntegers371 {
    int getSum(int a, int b) {
        int t;
        while (b!=0){
            t= a ^ b;
            b = (a & b)  << 1;
            a = t;
        }
        return a;
    }

    public static void main(String[] args) {
        SumOfTwoIntegers371 prog = new SumOfTwoIntegers371();
        System.out.println(prog.getSum(5,5));
    }
}
