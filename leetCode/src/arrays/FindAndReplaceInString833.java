package arrays;

import java.util.Arrays;

public class FindAndReplaceInString833 {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length(), curIndex;
        int[] rIndex = new int[n];
        Arrays.fill(rIndex, -1);

        for (int i=0; i<indices.length; i++){
            curIndex = indices[i];
            if (s.startsWith(sources[i], curIndex)){
                rIndex[curIndex] = i;
            }
        }

        StringBuilder replacementString = new StringBuilder();

        for (int i=0; i<n; ){
            if (rIndex[i] > -1){
                replacementString.append(targets[rIndex[i]]);
                i += sources[rIndex[i]].length();
            }else {
                replacementString.append(s.charAt(i++));
            }
        }
        return replacementString.toString();
    }
}
