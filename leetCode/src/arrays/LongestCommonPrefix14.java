package arrays;

public class LongestCommonPrefix14 {
    public static String longestCommonPrefix(String[] strs) {
        for (int i=0; i<strs[0].length(); i++){
            for (int j=1; j< strs.length; j++){
                if (strs[j].length() <= i || strs[j].charAt(i) != strs[0].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println("Longest common Prefix : "+ longestCommonPrefix(strs));
    }
}
