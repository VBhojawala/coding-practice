package graph.bfs;

import java.util.*;
import java.util.stream.Collectors;

public class MinimumGeneticMutation433 {
    class Mutation{
        String gene;
        int count;

        public Mutation(String gene, int count) {
            this.gene = gene;
            this.count = count;
        }
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankS = Arrays.stream(bank).collect(Collectors.toSet());

        Map<Character, String> mapping = new HashMap<>();
        mapping.put('A',"CGT");
        mapping.put('C',"AGT");
        mapping.put('G',"ACT");
        mapping.put('T',"ACG");

        Queue<Mutation> queue = new LinkedList<>();
        queue.offer(new Mutation(startGene, 0));

        while (!queue.isEmpty()){
            Mutation mutation = queue.poll();
            if (mutation.gene.equals(endGene))
                return mutation.count;
            for (int i=0; i<8; i++){
                for (char c : mapping.get(mutation.gene.charAt(i)).toCharArray()){
                    String next = mutation.gene.substring(0,i) + c + mutation.gene.substring(i+1);
                    if (bankS.contains(next)){
                        bankS.remove(next);
                        queue.offer(new Mutation(next, mutation.count + 1));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumGeneticMutation433 prog = new MinimumGeneticMutation433();
        String startGene = "AACCGGTT", endGene = "AACCGGTC";
        String bank[] = {"AACCGGTA","AACCGCTA","AACCGGTA"};

        System.out.println("No of Mutation : " + prog.minMutation(startGene, endGene, bank));

    }
}
