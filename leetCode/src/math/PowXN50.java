package math;

public class PowXN50 {
    public double myPow(double x, int n) {
        return  n < 0 ? 1.0 / dac(x,Math.abs(n)) : dac(x,n);
    }

    private  double dac(double x, long n){
        if (x == 0)
            return 0;
        if (n == 0)
            return 1;

        double result = dac(x * x, n / 2);

        if (n % 2 == 1)
            result *= x;

        return result;

    }

    public static void main(String[] args) {
        PowXN50 prog = new PowXN50();
        System.out.println(prog.myPow(2.00000, -2147483648));

    }
}
