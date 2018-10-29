import java.util.HashSet;
import java.util.Set;

public class NumUniqueEmails {
    public int numUniqueEmails(String[] emails) {
        Set<String> strs = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            StringBuilder str = new StringBuilder(emails[i]);
            boolean end = false;
            for (int j = 0; j < str.length(); ) {
                if (!end && str.charAt(j) == '.') str.deleteCharAt(j);
                else if (str.charAt(j) == '+') {
                    end = true;str.deleteCharAt(j);
                } else if (str.charAt(j) == '@') {
                    break;
                } else {
                    if (end) str.deleteCharAt(j);
                    else j++;
                }
            }
            strs.add(str.toString());
        }
        return strs.size();
    }

    public static void main(String[] args) {

        System.out.println( new NumUniqueEmails().numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
    }

}
