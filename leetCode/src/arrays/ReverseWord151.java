package arrays;

public class ReverseWord151 {
    public static String reverseWords(String s) {
        String result = "";
        s=s.strip();
        int front= s.length()-1;
        int rear = s.length();

        while (front > 0){
            if (s.charAt(front) == ' ' && s.charAt(front+1) == ' '){
                rear--;
            }
            if(s.charAt(front) == ' ' && s.charAt(front+1) != ' '){
                result += s.substring(front+1, rear);
                result += " ";
                rear=front;
            }
            front--;
        }
        result +=s.substring(0, rear);
        return  result;
    }

    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println("Reverse : "+ reverseWords(s));
    }
}
