package graph.general;

public class NumberOfProvinces547 {

    private int[] cc;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        cc = new int[n];
        for (int i=0;i<n;i++)
            cc[i] = i;

        int count = n, fi,fj;

        for (int i=0;i<n;i++){
            for (int j=i+1; j<n; j++){
                if (isConnected[i][j] == 1){
                    fi = find(i);fj = find(j);
                    if (fi != fj){
                        cc[fi] = fj;
                        count--;
                    }
                }
            }
        }

        return count;
    }

    private int find(int x){
        if (x != cc[x])
            cc[x] = find(cc[x]);
        return cc[x];
    }
}
