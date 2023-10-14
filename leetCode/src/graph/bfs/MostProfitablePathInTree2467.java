package graph.bfs;

import java.lang.reflect.Array;
import java.util.*;

public class MostProfitablePathInTree2467 {

    private List<Integer>[] adj;
    private int[] amount;
    private int[] ts;
    int maxProfit = Integer.MIN_VALUE;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = edges.length+1;
        adj = new List[n];
        ts = new int[n];
        this.amount = amount;
        Arrays.setAll(adj, k -> new ArrayList<>());
        Arrays.fill(ts, n);
        for (int[] edge : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        dfsB(bob,-1, 0);
        ts[bob] = 0;
        dfsA(0, -1, 0, 0);
        return maxProfit;
    }

    private boolean dfsB(int node, int prev, int time){
        if (node == 0){
            ts[node] = Math.min(ts[node], time);
            return true;
        }
        for (int adjNode : adj[node]){
            if (adjNode != prev && dfsB(adjNode, node, time+1)){
                ts[adjNode] = Math.min(ts[adjNode], time+1);
                return true;
            }
        }
        return false;
    }

    private void dfsA(int node, int prev, int time, int profit){
        if (time == ts[node]){
            profit += amount[node] / 2;
        }else if (time < ts[node]){
            profit += amount[node];
        }

        if (adj[node].size() == 1 && adj[node].get(0) == prev){
            maxProfit = Math.max(maxProfit, profit);
            return;
        }

        for (int adjNode: adj[node]){
            if (adjNode != prev)
                dfsA(adjNode, node, time+1, profit);
        }
    }
}
