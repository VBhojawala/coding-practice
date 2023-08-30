package twoPointers;

public class MergeStringsAlternately1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int left=0, right=0, m=word1.length(), n=word2.length();

        while (left < m && right < n){
            result.append(word1.charAt(left++));
            result.append(word2.charAt(right++));
        }

        if (left == m && right != n)
            result.append(word2.substring(right));
        else if(right == n && left !=m)
            result.append(word1.substring(left));

        return result.toString();
    }

    public static void main(String[] args) {
        MergeStringsAlternately1768 prog = new MergeStringsAlternately1768();
        System.out.println(prog.mergeAlternately("abc", "pqr"));
        System.out.println(prog.mergeAlternately("ab", "pqrs"));
        System.out.println(prog.mergeAlternately("abcd", "pq"));
    }
}
