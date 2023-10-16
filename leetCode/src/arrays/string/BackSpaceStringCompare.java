package arrays.string;

public class BackSpaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() -1, j= t.length() -1;
        int skipCountS = 0, skipCountT = 0;

        while (i > -1 || j > -1){
            while (i > -1){
                if (s.charAt(i) == '#') {
                    skipCountS++;
                    i--;
                } else if (skipCountS > 0) {
                    skipCountS--;
                    i--;
                } else{
                    break;
                }
            }

            while (j >-1){
                if (t.charAt(j) == '#'){
                    skipCountT++;
                    j--;
                } else if(skipCountT > 0){
                    skipCountT--;
                    j--;
                } else {
                    break;
                }
            }

            if (i > -1 && j > -1 && s.charAt(i) != t.charAt(j))
                return false;

            if ((i>-1) != (j>-1))
                return false;

            i--; j--;

        }

        return true;
    }
}
