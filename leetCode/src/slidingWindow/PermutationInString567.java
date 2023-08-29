package slidingWindow;

public class PermutationInString567 {

    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n= s2.length();
        if (m > n) return false;

        int[] count = new int[26];
        int diff=0;

        for (int i=0;i<m;i++){
            count[s1.charAt(i) - 'a']--;
            count[s2.charAt(i)- 'a']++;
        }

        for (int c : count){
            if (c !=0)
                diff++;
        }

        if (diff == 0)
            return true;

        for (int i=m;i<n;i++){
            int a = s2.charAt(i-m) -'a';
            int b = s2.charAt(i) -'a';

            if (count[b] == 0)
                diff++;
            if (count[a] == 0)
                diff++;
            if (++count[b] == 0)
                diff--;
            if (--count[a] == 0)
                diff--;

            if (diff == 0)
                return true;
        }
        return false;
    }

}
