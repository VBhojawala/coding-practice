package graph.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindIfPathExistsInGraph1971 {
    private int destination;
    private boolean[] visited;
    private List<Integer>[] adj;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        this.destination = destination;
        visited = new boolean[n];
        adj = new List[n];
        Arrays.setAll(adj, k -> new ArrayList<>());
        for (int[] edge : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        return dfs(source);
    }

    private boolean dfs(int curNode){
        if (curNode == destination) return true;
        visited[curNode] = true;
        for (int adjNode : adj[curNode]){
            if (!visited[adjNode] && dfs(adjNode))
                return true;
        }
        return false;
    }
}
