package hashmap.rollingHash;

public class CheckIfStringContainAllBinaryCodesOfSizeK {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        if (n-k+1 < (1 << k)) return false;
        boolean[] codes = new boolean[1<<k];
        int cur = Integer.parseInt(s.substring(0,k), 2);
        codes[cur] = true;

        int prev, next, count=1;

        for (int i=k; i<n; i++){
            prev = (s.charAt(i-k) - '0') << (k-1);
            next = s.charAt(i) - '0';
            cur = ( (cur- prev) << 1 ) |  next;
            if (!codes[cur]){
                codes[cur] = true;
                count++;
            }
        }

        return count == codes.length;
    }

    public static void main(String[] args) {
        CheckIfStringContainAllBinaryCodesOfSizeK prog = new CheckIfStringContainAllBinaryCodesOfSizeK();
        System.out.println(prog.hasAllCodes("00110110", 2));
        System.out.println(prog.hasAllCodes("0110", 2));
    }
}
