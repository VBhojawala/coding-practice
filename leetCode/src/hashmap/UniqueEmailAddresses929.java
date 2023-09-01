package hashmap;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        StringBuilder temp = new StringBuilder();
        for (String email: emails){
            temp.delete(0, temp.length());
            for (int i=0;i< email.length();i++){
                if (email.charAt(i) == '+' || email.charAt(i) == '@')
                    break;
                if (email.charAt(i) == '.')
                    continue;
                temp.append(email.charAt(i));
            }
            temp.append(email.substring(email.lastIndexOf('@')));
            uniqueEmails.add(temp.toString());
        }
        return uniqueEmails.size();
    }

    public static void main(String[] args) {
        UniqueEmailAddresses929 prog = new UniqueEmailAddresses929();
        System.out.println(prog.numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
        System.out.println(prog.numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.email@leetcode.com"}));
    }
}
