package graph.general;

public class NumberOfConnectedComponents323 {

    int cc[];
    public int countComponents(int n, int[][] edges) {
        cc = new int[n];

        for (int i=0;i<n;i++)
            cc[i] = i;

        for (int[] edge: edges)
            cc[find(edge[0])] =find(edge[1]);

        int count=0;
        for (int i=0;i<n;i++){
            if (i == find(i))
                count++;
        }

        return count;
    }

    private int find(int x){
        if (cc[x] != x)
            cc[x] = find(cc[x]);
        return cc[x];
    }

    public static void main(String[] args) {
        NumberOfConnectedComponents323 prog = new NumberOfConnectedComponents323();
        int[][] edges = new int[][] {{0,1},{1,2},{3,4}};
        System.out.println(prog.countComponents(5, edges));

    }
}
