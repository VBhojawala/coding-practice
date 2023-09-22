package dynamicProgramming.oneDimensional;

import java.util.*;

public class BestTeamWithNoConflicts1626 {

    class Player{
        int score, age;
        public  Player(int score, int age){
            this.score = score;
            this.age = age;
        }

        public int getScore() {
            return score;
        }

        public int getAge() {
            return age;
        }
    }
    public int bestTeamScore(int[] scores, int[] ages) {
        int n= scores.length;
        List<Player> playerList = new ArrayList<>();

        for (int i=0; i<n; i++)
            playerList.add(new Player(scores[i], ages[i]));

        Collections.sort(playerList, Comparator.comparingInt(Player::getScore)
                .thenComparing(Player::getAge));

        int[] dp = new int[n];
        int result = 0;

        for (int i=0; i<n; i++){
            for (int j=0; j < i; j ++) {
                if (playerList.get(j).age <= playerList.get(i).age)
                    dp[i] = Math.max(dp[i], dp[j]);
            }
            dp[i] += playerList.get(i).score;
            result = Math.max(result, dp[i]);
        }

        return result;
    }

    public int bestTeamScore2(int[] scores, int[] ages) {
        int n= scores.length, result =0;
        int[][] players = new int[n][2];

        for (int i=0; i<n; i++){
            players[i][0] = scores[i];
            players[i][1] = ages[i];
        }

        Arrays.sort(players, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int[] dp = new int[n];

        for (int i=0; i<n; i++){
            for (int j=0; j<i; j++){
                if (players[j][1] <= players[i][1]){
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += players[i][0];
            result = Math.max(result, dp[i]);
        }

        return result;
    }



    public static void main(String[] args) {
        BestTeamWithNoConflicts1626 prog = new BestTeamWithNoConflicts1626();
        System.out.println(prog.bestTeamScore2(new int[]{1,3,5,10,15}, new int[]{1,2,3,4,5}));
        System.out.println(prog.bestTeamScore2(new int[]{4,5,6,5}, new int[]{2,1,2,1}));
    }
}
