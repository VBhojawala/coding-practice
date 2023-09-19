package dynamicProgramming.oneDimensional;

public class SolvingQuestionsWithBrainPower2140 {
    public long mostPoints(int[][] questions) {
        int n = questions.length, points, brainPower, nxt;
        long[] dp = new long[n+1];

        for (int i=n-1; i>=0; i--){
            points = questions[i][0];
            brainPower = questions[i][1];
            nxt = i + brainPower + 1;
            dp[i] = Math.max(dp[i+1], points + (nxt > n ? 0 : dp[nxt]));
        }

        return dp[0];
    }
}
