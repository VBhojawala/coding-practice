package math;

public class ArmstrongNumber1134 {
    public boolean isArmstrong(int n) {
        int len = (n + "").length();
        int a=0;
        for (int i=n; i >0;i /= 10){
            a += Math.pow(i %10, len);
        }
        return a == n;
    }
}
