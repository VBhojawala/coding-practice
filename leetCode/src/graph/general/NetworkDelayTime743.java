package graph.general;

import java.util.*;

public class NetworkDelayTime743 {

    public static class Edge{
        int v;
        int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i=1;i<=n;i++)
            graph.put(i, new ArrayList<>());

        int u,  v,  w;
        for (int[] time : times){
            u= time[0]; v= time[1]; w=time[2];
            graph.get(u).add(new Edge(v,w));
        }

        PriorityQueue<Edge> minHeap =  new PriorityQueue<>(Comparator.comparingInt(e->e.w));
        Set<Integer> visited = new HashSet<>();
        int max=0;
        minHeap.add(new Edge(k,0));

        while (!minHeap.isEmpty()){
            Edge source = minHeap.poll();
            if (visited.contains(source.v))
                continue;
            visited.add(source.v);
            max= Math.max(max, source.w);

            for (Edge neighbour : graph.get(source.v)){
                minHeap.add(new Edge(neighbour.v, source.w + neighbour.w));
            }
        }
        return visited.size() == n ? max: -1 ;
    }

    public static void main(String[] args) {
        NetworkDelayTime743 prog = new NetworkDelayTime743();
        int[][] times = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(prog.networkDelayTime(times, 4, 2));

        times = new int[][]{{1,2,1}};
        System.out.println(prog.networkDelayTime(times, 2, 1));
    }
}
