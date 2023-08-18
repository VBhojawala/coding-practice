package arrays;

import java.util.ArrayList;
import java.util.List;

public class TextJustification68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length, len=0;

        List<String> wordList = new ArrayList<>();
        for(int i=0; i<n;){

            wordList.clear();

            wordList.add(words[i]);
            len = words[i].length();
            i++;

            while (i < n && len + words[i].length() +1 <= maxWidth){
                wordList.add(words[i]);
                len += words[i++].length() + 1;
            }

            if( i == n || wordList.size() == 1){
                String left = String.join(" ", wordList);
                String right = " ".repeat(maxWidth - left.length());
                result.add(left + right);
                continue;
            }

            int spareWidth = maxWidth - (len - wordList.size() + 1);
            int dw = spareWidth / ( wordList.size() -1 );
            int dq = spareWidth % ( wordList.size() -1 );

            StringBuilder row = new StringBuilder();
            for (int j=0; j< wordList.size() -1; j++){
                row.append(wordList.get(j));
                row.append(" ".repeat(dw + (j < dq ? 1 : 0)));
            }
            row.append(wordList.get(wordList.size()-1));
            result.add(row.toString());
        }

        return  result;
    }

    public static void main(String[] args) {
        TextJustification68 prog = new TextJustification68();
        System.out.println(prog.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
    }
}
