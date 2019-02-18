package bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maple on 2019/2/18 14:39.
 * @version v1.0
 * @see 1040441325@qq.com
 * 复原IP地址
 */
public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> ips = new ArrayList<>();

        restore(s,4,"",ips);
        return ips;
    }
    private void  restore(String s, int k, String out ,List<String> ips){
        if (k==0){
            if (s.isEmpty())ips.add(out);
        }else {
            for (int i = 1; i <4 ; i++) {
                if (s.length()>=i &&isValid(s.substring(0,i))){
                    if (k==1)restore(s.substring(i),k-1,out+s.substring(0,i),ips);
                    else restore(s.substring(i),k-1,out+s.substring(0,i)+".",ips);
                }
            }
        }
    }
    private boolean isValid(String s){
        if (s.isEmpty()||s.length()>3||(s.length()>1&&s.charAt(0)=='0'))return false;
        int res = Integer.valueOf(s);
        return res<=255&&res>=0;
    }
    public static void main(String[] a){
        new RestoreIpAddresses().restoreIpAddresses("25525511135");
    }
}
