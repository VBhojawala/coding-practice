package graph.general;

import java.util.*;

public class GraphValidTree178 {

    Map<Integer, List<Integer>> adj;
    Set<Integer> visited;
    public boolean validTree(int n, int[][] edges) {
        if (n==0)
            return true;

        adj = new HashMap<>();
        visited = new HashSet<>();

        for (int[] edge : edges){
            adj.computeIfAbsent(edge[0],e-> new ArrayList<>());
            adj.computeIfAbsent(edge[1],e-> new ArrayList<>());
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        return dfs(0,-1) && visited.size() == n;
    }

    private boolean dfs(int node, int prev){
        if (visited.contains(node))
            return false;
        if (!adj.containsKey(node))
            return true;

        visited.add(node);

        for (Integer neighbour : adj.get(node)){
            if (neighbour == prev)
                continue;

            if(!dfs(neighbour, node))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        GraphValidTree178 prog = new GraphValidTree178();
        int[][] edges = new int[][] {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(prog.validTree(5,edges));
        edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}} ;
        System.out.println(prog.validTree(5, edges));

    }
}
