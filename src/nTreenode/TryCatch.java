package nTreenode;

/**
 * @author maple on 2019/6/4 17:16.
 * @version v1.0
 * @see 1040441325@qq.com
 */
public class TryCatch {
    public static void main(String[] args) {
        System.out.println(action());
    }

    private static String action() {
        try {
            //System.exit(-1);//强制终端虚拟机,后续finally不执行
            int a=1/0;
            return "Try";
        } catch (Exception e) {
            System.out.println("action:catch");
            return "action";
        } finally {

            System.out.println("action: finally");
            return "finally";
        }
    }
}
