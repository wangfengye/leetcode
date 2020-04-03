/**
 * 字符串转换整数 (atoi)
 */
public class MyAtoi {
    public static int myAtoi(String str) {
        char[] strcs = str.toCharArray();
        int i = 0;
        boolean seq = false;//有无负号
        while (i < strcs.length) {
            char tmp = strcs[i];
            if (tmp == ' ') {
                i++;
            } else if (tmp >= '0' && tmp <= '9') {
                break;
            } else if (tmp == '+') {
                i++;
                break;
            } else if (tmp == '-') {
                i++;
                seq = true;
                break;
            } else {
                return 0;
            }
        }
        int res = 0;
        while (i < strcs.length) {
            char tmp = strcs[i];
            if (tmp >= '0' && tmp <= '9') {
                int c = tmp - '0';
                if (seq) {
                    //check
                    if ((Integer.MIN_VALUE + c) / 10<= -res) {
                        res = res * 10+c;
                    } else {
                        return Integer.MIN_VALUE ;
                    }

                } else {
                    if ((Integer.MAX_VALUE - c) / 10>= res) {
                        res = res * 10 + c;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
                i++;
            } else {
                break;
            }
        }
        return seq?-res:res;
    }
    public static void main(String[] args){
        myAtoi("2147483646");
    }
}
