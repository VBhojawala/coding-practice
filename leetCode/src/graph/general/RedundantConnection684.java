package graph.general;

import java.util.Arrays;

public class RedundantConnection684 {

    int cc[];
    public int[] findRedundantConnection(int[][] edges) {
        cc = new int[edges.length+1];

        for (int i=0; i<=edges.length;i++){
            cc[i] = i;
        }

        for (int[] edge: edges){
            int a= edge[0], b= edge[1];
            if (find(a) == find(b))
                return edge;
            cc[find(a)] = find(b);

        }
        return null;
    }

    private int find(int x){
        if (cc[x] != x)
            cc[x] =find(cc[x]);
        return cc[x];
    }

    public static void main(String[] args) {
        RedundantConnection684 prog = new RedundantConnection684();
        int[][] edges = new int[][] {{1,2},{2,3},{3,4},{1,4},{1,5}};
        Arrays.stream(prog.findRedundantConnection(edges)).forEach(System.out::println);
    }
}
