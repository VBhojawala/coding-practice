package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses22 {

    List<String> result = new ArrayList<>();
    StringBuilder combination;
    int n;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        combination = new StringBuilder(2*n);
        backtrack(0,0);
        return result;
    }

    private void backtrack(int left, int right){
        if (left == n && right == n){
            result.add(combination.toString());
            return;
        }

        if(left < n){
            combination.append("(");
            backtrack(left+1, right);
            combination.deleteCharAt(combination.length()-1);
        }

        if (left > right){
            combination.append(")");
            backtrack(left, right+1);
            combination.deleteCharAt(combination.length() -1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses22 prog = new GenerateParentheses22();
        System.out.println(prog.generateParenthesis(3));
    }
}
