/**
 * 1108. IP 地址无效化
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 *
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 */
public class DefangIPaddr {
    public static String defangIPaddr(String address) {
        StringBuilder builder=new StringBuilder(address);
        for (int i=builder.length()-1;i>=0;i--){
            if(builder.charAt(i)=='.'){
                builder.insert(i+1,']');
                builder.insert(i,'[');
            }
        }
        return builder.toString();
    }
    public static void main(String[] args){
        System.out.println(defangIPaddr("1.1.1.1"));
        System.out.println(defangIPaddr("255.100.50.0"));
    }
}
