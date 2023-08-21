package graph.general;

import java.util.*;


public class MinCostToConnectAllPoints1584 {
    public class Edge{
        int v;
        int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Map<Integer, List<Edge>> adj = new HashMap<>();

        for (int i=0;i<n;i++)
            adj.put(i, new ArrayList<>());

        for (int i=0; i<n;i++){
            int[] point1 = points[i];
            for(int j=i+1; j<n;j++){
                int[] point2 = points[j];
                int w = Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
                adj.get(i).add(new Edge(j, w));
                adj.get(j).add(new Edge(i, w));
            }
        }

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(e->e.w));
        int total =0;
        minHeap.add(new Edge(0,0));

        while (visited.size() < n){
            Edge e = minHeap.poll();

            if (visited.contains(e.v))
                continue;

            total += e.w;
            visited.add(e.v);

            for (Edge neighbour : adj.get(e.v)){
                if (!visited.contains(neighbour.v))
                    minHeap.offer(neighbour);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        MinCostToConnectAllPoints1584 prog = new MinCostToConnectAllPoints1584();
        int[][] points = new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(prog.minCostConnectPoints(points));

        points= new int[][]{{3,12},{-2,5},{-4,1}};
        System.out.println(prog.minCostConnectPoints(points));
    }
}
