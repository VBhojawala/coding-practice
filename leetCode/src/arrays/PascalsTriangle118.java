package arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        result.add(prev);

        for (int i=1; i< numRows;i++){
            List<Integer> curr = new ArrayList<>();
            curr.add(prev.get(0));
            for (int j=1;j< prev.size();j++)
                curr.add(prev.get(j) + prev.get(j-1));
            curr.add(prev.get(prev.size()-1));
            result.add(curr);
            prev = curr;
        }

        return result;
    }

    public static void main(String[] args) {
        PascalsTriangle118 prog = new PascalsTriangle118();
        System.out.println(prog.generate(5));
    }
}
