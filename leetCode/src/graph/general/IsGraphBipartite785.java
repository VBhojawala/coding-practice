package graph.general;

import java.util.Arrays;

public class IsGraphBipartite785 {

    private int[] color;
    private int[][] graph;
    public boolean isBipartite(int[][] graph) {
        this.graph = graph;
        int n = graph.length;
        color = new int[n];
        Arrays.fill(color, -1);
        for (int i=0; i<n; i++){
            if (color[i] == -1 && !dfs(i, 1)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, int nodeColor){
        color[node] = nodeColor;
        for (int adj : graph[node]){
            if (color[adj] == -1){
                if (!dfs(adj, nodeColor ^ 1))
                    return false;
            } else if (color[adj] == nodeColor){
                return false;
            }
        }
        return true;
    }
}
