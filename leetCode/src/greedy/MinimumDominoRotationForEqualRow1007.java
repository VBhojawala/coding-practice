package greedy;

public class MinimumDominoRotationForEqualRow1007 {

    private int n;
    private int[] tops;
    private int[] bottoms;
    public int minDominoRotations(int[] tops, int[] bottoms) {
        n = tops.length;
        this.tops = tops; this.bottoms = bottoms;
        int count = Math.min(rotate(tops[0]), rotate(bottoms[0]));
        return count == Integer.MAX_VALUE ? -1 : count;
    }

    private int rotate(int pivot){
        int cnt1=0, cnt2 =0;
        for (int i=0; i<n; i++){
            if (tops[i] != pivot && bottoms[i] != pivot)
                return Integer.MAX_VALUE;
            cnt1 += tops[i] == pivot ? 1 : 0;
            cnt2 += bottoms[i] == pivot ? 1 : 0;
        }
        return n - Math.max(cnt1, cnt2);
    }
}
