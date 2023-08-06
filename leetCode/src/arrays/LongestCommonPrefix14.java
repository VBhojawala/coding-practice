package arrays;

public class LongestCommonPrefix14 {
    public static String longestCommonPrefix(String[] strs) {
        String result = "";
        boolean match = true;
        for(int i=0;i<strs[0].length(); i++){
            for(int j=1; j <strs.length; j++){
                if(strs[j].length() <= i){
                    match = false;
                    break;
                }
                if(strs[j].length() > i && strs[0].charAt(i) !=strs[j].charAt(i)){
                    match = false;
                    break;
                }

            }
            if(match){
                result += strs[0].charAt(i);
            }
            else{
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println("Longest common Prefix : "+ longestCommonPrefix(strs));
    }
}
