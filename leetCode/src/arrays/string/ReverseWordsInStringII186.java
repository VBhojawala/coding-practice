package arrays.string;

public class ReverseWordsInStringII186 {

    private char[] s;
    public void reverseWords(char[] s) {
        this.s = s;
        int n = s.length;
        for (int i=0, j=0; j < n; j++){
            if (s[j] == ' '){
                reverse(i,j-1);
                i = j+1;
            }
            else if (j == n-1){
                reverse(i, j);
            }
        }

        reverse(0, n-1);
    }

    private void reverse(int left, int right){
       for(;left < right; left++, right--){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }


}
