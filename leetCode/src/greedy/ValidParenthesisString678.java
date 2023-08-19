package greedy;

public class ValidParenthesisString678 {
    public boolean checkValidString(String s) {
        int leftMin=0, leftMax=0;
        for (char ch : s.toCharArray()){
            if (ch == '('){
                leftMin++;leftMax++;
            }
            else if (ch == ')'){
                leftMin--;leftMax--;
            }else {
               leftMin--; leftMax++;
            }
            if (leftMax < 0)
                return false;
            if (leftMin < 0)
                leftMin = 0;
        }
        return leftMin == 0;
    }

    public static void main(String[] args) {
        ValidParenthesisString678 prog = new ValidParenthesisString678();
        System.out.println(prog.checkValidString("(*)("));
        System.out.println(prog.checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"));
    }
}
