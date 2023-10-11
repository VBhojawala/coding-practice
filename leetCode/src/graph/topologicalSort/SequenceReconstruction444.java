package graph.topologicalSort;

import java.util.*;

public class SequenceReconstruction444 {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        int n= nums.length;
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        int m, max = 1;
        for (List<Integer> edges : sequences){
            m= edges.size();
            for (int i=0; i<m-1; i++){
                max = Math.max(max, Math.max(edges.get(i), edges.get(i+1)));
                adj.computeIfAbsent(edges.get(i), k-> new HashSet<>()).add(edges.get(i+1));
            }

        }
        if (max < n) return false;
        for (int i=0; i<n-1; i++){
            if (!adj.containsKey(nums[i]) || !adj.get(nums[i]).contains(nums[i+1]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SequenceReconstruction444 prog = new SequenceReconstruction444();
        int[] nums = new int[]{4,1,5,2,6,3};
        List<List<Integer>> sequenence = new ArrayList<>();
        sequenence.add(Arrays.asList(5,2,6,3));
        sequenence.add(Arrays.asList(4,1,5,2));
        System.out.println(prog.sequenceReconstruction(nums, sequenence));
    }
}
