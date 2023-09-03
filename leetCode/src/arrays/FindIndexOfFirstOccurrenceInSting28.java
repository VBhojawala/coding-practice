package arrays;

public class FindIndexOfFirstOccurrenceInSting28 {
    public int strStr(String haystack, String needle) {
        if(haystack.length()<needle.length()) return -1;

        int n=haystack.length();
        int m=needle.length();

        int d=256;
        int q=101;
        int h=1;

        for(int i=0;i<m-1;i++){
            h=(h*d)%q;
        }

        int p=0;
        int t=0;

        for(int i=0;i<m;i++){
            p=(d*p + needle.charAt(i))%q;
            t=(d*t + haystack.charAt(i))%q;
        }

        for(int i=0;i<=n-m;i++){
            if(p==t){
                boolean flag=true;
                for(int j=0;j<m;j++){
                    if(haystack.charAt(j+i) != needle.charAt(j)){
                        flag=false;
                        break;
                    }
                }
                if(flag) return i;
            }
            if(i<n-m){
                t=(d*(t-haystack.charAt(i)*h) + haystack.charAt(i+m)) % q;
                if(t<0) t+=q;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        FindIndexOfFirstOccurrenceInSting28 prog = new FindIndexOfFirstOccurrenceInSting28();
        System.out.println(prog.strStr("madsaaadbutsad", "saaad"));
    }
}
