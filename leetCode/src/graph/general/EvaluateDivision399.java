package graph.general;

import java.util.*;

public class EvaluateDivision399 {
    class  Node{
        String name;
        Double weight;

        public Node(String name, Double weight) {
            this.name = name;
            this.weight = weight;
        }
    }
    Map<String, List<Node>> graph = new HashMap<>();

    public double[] calcEquation(
            List<List<String>> equations, double[] values, List<List<String>> queries) {

        double[] ans = new double[queries.size()];

        for (int i=0; i< equations.size(); i++){
            List<String> equation = equations.get(i);

            graph.computeIfAbsent(equation.get(0), k -> new ArrayList<>());
            graph.computeIfAbsent(equation.get(1), k -> new ArrayList<>());

            graph.get(equation.get(0)).add(new Node(equation.get(1), values[i]));
            graph.get(equation.get(1)).add(new Node(equation.get(0), 1/values[i]));
        }

        for (int i=0; i< queries.size();i++){
            ans[i] = bfs(queries.get(i).get(0), queries.get(i).get(1));
        }

        return ans;
    }

    private double bfs(String source, String target){
        if (!graph.containsKey(source) || !graph.containsKey(target))
                return -1.0;

        Queue<Node> queue= new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.add(new Node(source, 1.0));
        visited.add(source);

        while (!queue.isEmpty()){
            Node curNode = queue.poll();
            if (curNode.name == target)
                return curNode.weight;

            for (Node node : graph.get(curNode.name)){
                if (!visited.contains(node.name)){
                    queue.offer(new Node(node.name, curNode.weight * node.weight));
                    visited.add(node.name);
                }
            }
        }
        return -1.0;
    }


    public static void main(String[] args) {

//        List<List<String>> equations = new ArrayList<>();
//        List<String> ab = new ArrayList<>(); ab.add("a"); ab.add("b");
//        List<String> bc = new ArrayList<>(); bc.add("b"); bc.add("c");
//        equations.add(ab); equations.add(bc);
//
//        double[] values = {2.0,3.0};
//
//        List<List<String>> queries = new ArrayList<>();
//        List<String> ac = new ArrayList<>(); ac.add("a"); ac.add("c");
//        List<String> ba = new ArrayList<>(); ba.add("b"); ba.add("a");
//        List<String> ae = new ArrayList<>(); ae.add("a"); ae.add("e");
//        List<String> aa = new ArrayList<>(); aa.add("a"); aa.add("a");
//        List<String> ax = new ArrayList<>(); ax.add("a"); ax.add("x");
//        queries.add(ac);queries.add(ba);queries.add(ae);
//        queries.add(aa);queries.add(ax);
//
//        EvaluateDivision399 prog = new EvaluateDivision399();
//
//       double[] result = prog.calcEquation(equations, values, queries);
//       for (int i=0; i<result.length;i++){
//           System.out.print(result[i] + "  ");
//       }
        // Set 2
        List<List<String>> equations = new ArrayList<>();
        List<String> ab = new ArrayList<>(); ab.add("a"); ab.add("b");
        List<String> bc = new ArrayList<>(); bc.add("b"); bc.add("c");
        List<String> bccd = new ArrayList<>(); bccd.add("bc"); bccd.add("cd");
        equations.add(ab); equations.add(bc); equations.add(bccd);

        double[] values = {1.5,2.5,5.0};

        List<List<String>> queries = new ArrayList<>();
        List<String> ac = new ArrayList<>(); ac.add("a"); ac.add("c");
        List<String> cb = new ArrayList<>(); cb.add("c"); cb.add("b");
        List<String> bccdq = new ArrayList<>(); bccdq.add("bc"); bccdq.add("cd");
        List<String> cdbc = new ArrayList<>(); cdbc.add("cd"); cdbc.add("bc");
        queries.add(ac);queries.add(cb);queries.add(bccdq);
        queries.add(cdbc);

        EvaluateDivision399 prog = new EvaluateDivision399();

        double[] result = prog.calcEquation(equations, values, queries);
        for (int i=0; i<result.length;i++){
            System.out.print(result[i] + "  ");
        }



    }
}
