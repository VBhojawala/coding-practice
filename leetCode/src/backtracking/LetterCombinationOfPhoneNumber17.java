package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber17 {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if(digits.isEmpty()) return result;

        result.add("");
        String[] chars = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for (char digit : digits.toCharArray()){
            List<String> newResult = new ArrayList<>();
            for (String x : result){
                for (String y : chars[digit - '2'].split("")){
                    newResult.add(x+y);
                }
            }
            result = newResult;
        }
        return result;
    }

    public static void main(String[] args) {
        LetterCombinationOfPhoneNumber17 prog = new LetterCombinationOfPhoneNumber17();
        System.out.println(prog.letterCombinations("23"));
    }
}
