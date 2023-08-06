package stack;

import java.util.Stack;

public class SimplifyPath71 {

    public static String simplifyPath(String path) {
        Stack<String> foldStack = new Stack<>();
        for(String folder : path.split("/")){
            if(folder.isEmpty() || folder.equals(".")) {
            }
            else if(folder.equals("..")){
                if (!foldStack.isEmpty())
                    foldStack.pop();
            }else {
                foldStack.push(folder);
            }
        }
        return "/"+ String.join("/", foldStack);

    }

    public static void main(String[] args) {
        String s = "/../";
        System.out.println("Simple Path : "+ simplifyPath(s));
    }
}
