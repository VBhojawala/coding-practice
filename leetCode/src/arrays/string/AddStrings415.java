package arrays.string;

public class AddStrings415 {

    public String addStrings(String num1, String num2) {
        int n1, n2, carry=0;
        int m= num1.length(), n = num2.length();
        int i=m-1,j=n-1, sum;
        StringBuilder ans = new StringBuilder();

        while (i > -1 || j > -1 || carry !=0){
            n1 = i > -1 ? Integer.valueOf(num1.charAt(i--) - '0') : 0;
            n2 = j > -1 ? Integer.valueOf(num2.charAt(j--) - '0') : 0;
            sum = n1 + n2 + carry;
            ans.append(sum % 10);
            carry = sum / 10;
        }

        return ans.reverse().toString();

    }

    public static void main(String[] args) {
        AddStrings415 prog = new AddStrings415();
        System.out.println(prog.addStrings("486", "123"));
    }

}
