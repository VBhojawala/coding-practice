package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeStrings271 {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for (String str : strs){
            result.append(str.length());
            result.append('#');
            result.append(str);
        }

        return result.toString();
    }
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int n=s.length(), left=0, right=0,len;

        while (right < n){
            left = right;

            while (Character.isDigit(s.charAt(right)))
                right++;

            len = Integer.parseInt(s.substring(left,right));

            left = right + 1;
            right = right + len + 1;

            result.add(s.substring(left, right));
        }

        return result;
    }

    public static void main(String[] args) {
        EncodeAndDecodeStrings271 prog = new EncodeAndDecodeStrings271();
        System.out.println(prog.decode(prog.encode(Arrays.asList("leet","code","love","you"))));
        System.out.println(prog.decode(prog.encode(Arrays.asList("we", "say", ":", "yes"))));
    }
}
