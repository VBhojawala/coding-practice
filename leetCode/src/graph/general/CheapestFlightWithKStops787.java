package graph.general;

import java.util.*;

public class CheapestFlightWithKStops787 {
    private static final int INF = 0x3f3f3f3f;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        int[] tempPrice = new int[n];
        Arrays.fill(prices,INF);
        prices[src] = 0;

        int s,d,p;
        for (int i=0; i <=k;i++){
            System.arraycopy(prices, 0, tempPrice, 0, n);
            for (int[] flight : flights){
                s= flight[0]; d=flight[1]; p = flight[2];
                prices[d]= Math.min(prices[d], tempPrice[s] + p);
            }
        }
        return prices[dst] == INF ? -1 : prices[dst];
    }

    public static void main(String[] args) {
        CheapestFlightWithKStops787 prog = new CheapestFlightWithKStops787();
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        System.out.println(prog.findCheapestPrice(3,flights,0,2, 1));
        prog = new CheapestFlightWithKStops787();
        System.out.println(prog.findCheapestPrice(3,flights,0,2, 0));
        prog = new CheapestFlightWithKStops787();
        flights = new int[][] {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        System.out.println(prog.findCheapestPrice(4,flights,0,3, 1));

        prog = new CheapestFlightWithKStops787();
        flights= new int[][] {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
        System.out.println(prog.findCheapestPrice(4,flights,0,3, 1));
    }
}
