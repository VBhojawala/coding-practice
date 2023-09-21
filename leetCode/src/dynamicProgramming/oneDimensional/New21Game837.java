package dynamicProgramming.oneDimensional;

public class New21Game837 {
    public double new21Game(int n, int k, int maxPts) {
        if ( k == 0 || n>= k+maxPts) return 1.0;

        double dp[] = new double[n+1];
        double sum=1.0, result = 0.0;
        dp[0] = 1.0;

        for (int i=1;i<=n; i++){
            dp[i] = sum / maxPts;
            if (i<k)
                sum += dp[i];
            else
                result += dp[i];
            if (i-maxPts >= 0)
                sum -= dp[i-maxPts];
        }

        return result;
    }

    public static void main(String[] args) {
        New21Game837 prog = new New21Game837();
        System.out.println(prog.new21Game(10,1,10 ));
        System.out.println(prog.new21Game(2826,394,5191 ));
    }
}
