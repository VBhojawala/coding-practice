package graph.general;

import java.util.*;

public class ReconstructItinerary332 {

    Map<String, List<String>> adj;
    List<String> result;
    int n;
    public List<String> findItinerary(List<List<String>> tickets) {
        n= tickets.size();
        adj = new HashMap<>();

        Collections.sort(tickets, Comparator.comparing(ticket-> ticket.get(0) + ticket.get(1)));

        for (List<String> ticket : tickets){
            adj.computeIfAbsent(ticket.get(0), e-> new ArrayList<>());
            adj.get(ticket.get(0)).add(ticket.get(1));
        }

        result = new ArrayList<>();
        result.add("JFK");
        dfs("JFK");
        return  result;
    }

    private boolean dfs(String source){
        if (result.size() > n)
            return true;
        if (!adj.containsKey(source) || adj.get(source).isEmpty())
            return false;

        List<String> temp = new ArrayList<>(adj.get(source));

        for (int i=0; i< temp.size();i++){
            String v = adj.get(source).get(i);
            adj.get(source).remove(i);
            result.add(v);

            if (dfs(v))
                return true;

            adj.get(source).add(i, v);
            result.remove(result.size() -1);
        }

        return false;
    }

    public static void main(String[] args) {
        ReconstructItinerary332 prog = new ReconstructItinerary332();

        List<List<String>> tickets = new ArrayList<>();

        List<String> ticket1 = new ArrayList<>();
        ticket1.add("JFK"); ticket1.add("SFO");

        List<String> ticket2 = new ArrayList<>();
        ticket2.add("JFK"); ticket2.add("ATL");

        List<String> ticket3 = new ArrayList<>();
        ticket3.add("SFO"); ticket3.add("ATL");

        List<String> ticket4 = new ArrayList<>();
        ticket4.add("ATL"); ticket4.add("JFK");

        List<String> ticket5= new ArrayList<>();
        ticket5.add("ATL"); ticket5.add("SFO");

        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);


        System.out.println(prog.findItinerary(tickets));
    }
}
