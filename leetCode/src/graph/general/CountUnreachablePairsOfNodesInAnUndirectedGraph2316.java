package graph.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountUnreachablePairsOfNodesInAnUndirectedGraph2316 {

    private boolean[] visited;
    private List<Integer>[] adj;
    public long countPairs(int n, int[][] edges) {
        visited = new boolean[n];
        adj = new List[n];
        Arrays.setAll(adj, k -> new ArrayList<>());

        for (int[] edge : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        long count=0, size=0, tmp;
        for (int i=0; i<n; i++){
            if (!visited[i]){
                tmp = dfs(i);
                count += size * tmp;
                size += tmp;
            }
        }
        return count;
    }

    private int dfs(int i){
        visited[i] = true;
        int count = 1;
        for (int edge: adj[i]){
            if (!visited[edge])
                count += dfs(edge);
        }
        return count;
    }
}
