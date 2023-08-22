package graph.general;

public class GraphValidTree261UF {

    int[] cc;
    public boolean validTree(int n, int[][] edges) {
        cc = new int[n];

        for (int i=0 ; i<n; i++)
            cc[i] = i;

        for (int[] edge : edges){
            int a = edge[0], b=edge[1];
            if (find(a) == find(b))
                return false;
            cc[find(a)] = find(b);
            n--;
        }

        return n== 1;

    }

    private int find(int x){
        if (cc[x] != x)
            cc[x] = find(cc[x]);
        return cc[x];
    }
    public static void main(String[] args) {
        GraphValidTree261UF prog = new GraphValidTree261UF();
        int[][] edges = new int[][] {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(prog.validTree(5,edges));
        edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}} ;
        System.out.println(prog.validTree(5, edges));
    }
}
