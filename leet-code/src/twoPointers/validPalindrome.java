package twoPointers;

public class validPalindrome {

    public static boolean isPalindrome(String s) {

        int front=0;
        int rear = s.length() -1;
        boolean valid = true;

        while (front < rear){
            if(!Character.isLetterOrDigit(s.charAt(front))){
                front++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(rear))){
                rear--;
                continue;
            }

            if(Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(rear))){
                valid = false;
                break;

            }
            front++; rear--;
        }
        return valid;
    }


    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println("Is Palindrome ? :" + isPalindrome(s));
    }
}
