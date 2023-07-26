package arrays;

import java.util.stream.IntStream;

public class GasStation134 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
         if(IntStream.of(gas).sum() < IntStream.of(cost).sum()){
            return -1;
         }

         int totalCost=0, position=0;

         for(int i=0; i <cost.length; i++){
            totalCost+= gas[i] - cost[i];
            if(totalCost <0){
                position = i + 1;
                totalCost = 0;
            }
         }
         return  position;
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};

        System.out.println("Can Complete Circuit ? : " + canCompleteCircuit(gas, cost));

    }
}
