package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

class Project{
    int profit;
    int capital;

    public Project(int profit, int capital) {
        this.profit = profit;
        this.capital = capital;
    }
}
public class IPO502 {
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Project> minCapital = new PriorityQueue<>(Comparator.comparingInt(p -> p.capital));
        for (int i=0;i<profits.length;i++){
            minCapital.add(new Project(profits[i], capital[i]));
        }

        PriorityQueue<Integer> maxProfit = new PriorityQueue<>(Comparator.reverseOrder());

        while (k-- > 0){
            while (!minCapital.isEmpty() && minCapital.peek().capital <= w){
                maxProfit.add(minCapital.remove().profit);
            }
            if (maxProfit.isEmpty())
                return w;
            w += maxProfit.remove();
        }
        return w;
    }

    public static void main(String[] args) {
       int k = 2, w = 0;
       int[] profits = {1,2,3}, capital = {0,1,1};
       System.out.println(findMaximizedCapital(k, w, profits, capital));
    }
}
