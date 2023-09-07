package dynamicProgramming.oneDimensional;

public class PaintHouse256 {
    public int minCost(int[][] costs) {
        int r=0, g=0,b=0;
        int tmpR, tmpG, tmpB;

        for (int[] cost : costs){
            tmpR = r; tmpG = g; tmpB=b;
            r = cost[0] + Math.min(tmpG, tmpB);
            g = cost[1] + Math.min(tmpR, tmpB);
            b = cost[2] + Math.min(tmpR, tmpG);
        }

        return Math.min(r, Math.min(g,b));

    }

    public static void main(String[] args) {
        PaintHouse256 prog = new PaintHouse256();
        System.out.println(prog.minCost(new int[][]{{17,2,17},{16,16,5},{14,3,19}}));
    }
}
