package Array;

/**
 * 二进制求和
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int len = Math.max(aChars.length, bChars.length);
        char[] res = new char[len + 1];
        long flag = 0;

        for (int i = 0; i < len; i++) {
            int sum = 0;
            sum += flag;
            if (i < aChars.length) sum += (aChars[aChars.length - 1 - i] - '0');
            if (i < bChars.length) sum += (bChars[bChars.length - 1 - i] - '0');

            if (sum == 0) {
                res[len - i] = '0';
                flag = 0;
            } else if (sum == 1) {
                res[len - i] = '1';
                flag = 0;
            } else if (sum == 2) {
                res[len - i] = '0';
                flag = 1;
            } else {
                res[len - i] = '1';
                flag = 1;
            }
            if (flag == 1) res[0] = '1';
            else res[0] = '0';
        }
        return new String(res);
    }

    public String addBinary1(String a, String b) {
        char[] aChars;
        char[] bChars;
        if (a.length() > b.length()) {
            aChars = a.toCharArray();
            bChars = b.toCharArray();
        } else {
            aChars = b.toCharArray();
            bChars = a.toCharArray();
        }

        long flag = 0;
        int diff = aChars.length-bChars.length;
        for (int i =  aChars.length-1; i >=0; i--) {
          int temp =0;
          if (i>=diff)temp = bChars[i-diff]-'0';
          temp +=(aChars[i]-'0')+flag;
          if (temp%2==0)aChars[i]='0';
          else aChars[i]='1';
          if (temp>=2)flag=1;
          else flag=0;
        }
        return flag>0?1+ new String(aChars):new String(aChars);
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary1("11", "1"));
    }
}
