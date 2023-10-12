package graph.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimeNeededToInformAllEmployees1376 {

    private List<Integer>[] adj;
    private int[]informTime;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        adj = new List[n]; this.informTime = informTime;
        Arrays.setAll(adj, k-> new ArrayList<>());
        for (int i=0; i<n; i++){
            if (manager[i] > -1)
                adj[manager[i]].add(i);
        }
        return dfs(headID);
    }

    private int dfs(int i){
        int maxTime = 0;
        for (int directReporting : adj[i]){
            maxTime = Math.max(maxTime, dfs(directReporting) + informTime[i]);
        }
        return maxTime;
    }
}
