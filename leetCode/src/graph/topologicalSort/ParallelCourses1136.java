package graph.topologicalSort;

import java.util.ArrayList;
import java.util.List;

public class ParallelCourses1136 {

    private List<List<Integer>> graph = new ArrayList<>();
    int[] visited;
    public int minimumSemesters(int n, int[][] relations) {

        for (int i=0; i<=n; i++)
            graph.add(new ArrayList<>());

        for (int[] relation : relations)
            graph.get(relation[0]).add(relation[1]);

        visited = new int[n+1];
        int maxLen = 1;

        for (int i=1; i<=n; i++){
           int len =  dfs(i);
           if (len == -1) return -1;
           maxLen = Math.max(len, maxLen);
        }
        return maxLen;

    }

    private int dfs(int node){
        if (visited[node] != 0)
            return visited[node];
        else
            visited[node] = -1;

        int maxLen = 1;
        for (int edgeNode : graph.get(node)){
            int len = dfs(edgeNode);

            if (len == -1)  return -1;  // Detect Cycle

            maxLen = Math.max(len+1, maxLen);
        }

        visited[node] = maxLen;
        return maxLen;


    }
}
