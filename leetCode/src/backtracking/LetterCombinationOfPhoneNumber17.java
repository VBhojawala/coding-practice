package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber17 {

    String digits;
    int n;
    String[] dial = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder temp;

    List<String> result;
    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        n = digits.length();
        result = new ArrayList<>();
        temp = new StringBuilder();
        if(digits.isEmpty())
            return result;
        dfs(0);
        return result;

    }

    private void dfs(int i){
        if (i == n){
            result.add(temp.toString());
            return;
        }

        if (i > n)
            return;

        for (char ch : dial[digits.charAt(i) - '2'].toCharArray()){
            temp.append(ch);
            dfs(i+1);
            temp.deleteCharAt(temp.length() - 1);
        }

    }

    public static void main(String[] args) {
        LetterCombinationOfPhoneNumber17 prog = new LetterCombinationOfPhoneNumber17();
        System.out.println(prog.letterCombinations("23"));
    }
}
