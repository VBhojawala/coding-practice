package graph.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReOrderRoutesToMakeAllPathsLeadToTheCityZero {

    class Edge{
        int node;
        int dir;

        public Edge(int node, int dir) {
            this.node = node;
            this.dir = dir;
        }
    }

    Map<Integer, List<Edge>> adj;
    int count;
    public int minReorder(int n, int[][] connections) {
        adj = new HashMap<>();
        for (int[] connection : connections){
            adj.computeIfAbsent(connection[0], c-> new ArrayList<>())
                    .add(new Edge(connection[1], 1));
            adj.computeIfAbsent(connection[1], c-> new ArrayList<>())
                    .add(new Edge(connection[0], 0));
        }
        dfs(0,-1);
        return count;
    }

    private void dfs(int node, int parent){
        if (!adj.containsKey(node)) return;
        for (Edge e : adj.get(node)){
            if (e.node != parent){
                count += e.dir;
                dfs(e.node, node);
            }
        }
    }
}
