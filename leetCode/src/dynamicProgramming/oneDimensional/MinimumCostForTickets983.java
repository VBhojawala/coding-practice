package dynamicProgramming.oneDimensional;

public class MinimumCostForTickets983 {
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length-1];
        int[] dp = new int[lastDay+1];
        for (int travelDay=0, curDay=1; curDay <=lastDay; curDay++){

            if (curDay < days[travelDay])
                dp[curDay] = dp[curDay-1];
            else {
                travelDay++;
                dp[curDay] = Math.min(dp[curDay-1]+ costs[0],
                        Math.min(dp[Math.max(0, curDay-7)] + costs[1],
                                dp[Math.max(0, curDay-30)] + costs[2]));
            }
        }
        return dp[lastDay];
    }

    public static void main(String[] args) {
        MinimumCostForTickets983 prog = new MinimumCostForTickets983();
        System.out.println(prog.mincostTickets(new int[]{1,4,6,7,8,20}, new int[]{2,7,15}));
        System.out.println(prog.mincostTickets(new int[]{1,2,3,4,5,6,7,8,9,10,30,31}, new int[]{2,7,15}));
    }
}
