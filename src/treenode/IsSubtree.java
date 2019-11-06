package treenode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author maple on 2019/7/29 17:11.
 * @version v1.0
 * @see 1040441325@qq.com
 * 572. 另一个树的子树
 * <p>
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 * <p>
 * 示例 1:
 * 给定的树 s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * 给定的树 t：
 * <p>
 * 4
 * / \
 * 1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 2:
 * 给定的树 s：
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * /
 * 0
 * 给定的树 t：
 * <p>
 * 4
 * / \
 * 1   2
 * 返回 false。
 */
public class IsSubtree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (isSame(s, t)) return true;
        if (s == null) return false;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSame(s.left, t.left) && isSame(s.right, t.right);

    }
    public static void main(String[] s){
      /*  try {
            System.out.println(URLEncoder.encode("我","UTF-8"));
            System.out.println(URLDecoder.decode("%E6%88%91","UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
      String[] src= new String[]{"0601","0602","0603","0604","0605","0606","0607","0608","0609","0610","0611","0612","0613","0614","0615"
      ,"0616","0617","0618","0619","0620","0621","0701","0702","0703","0704","0705","0706","0708"};
      String[] days = new String[]{"0724","0725","0726","0727","0728","0729","0730","0731","0801","0802","0803","0804",
      "0805","0806","0807"};

        for (String suffix : src) {
          //  System.out.println("CALL initTask('hz19"+suffix+"', 'bg_data_hz.t_device','bg_data_hz.tlog_apl2019"+suffix+"');");
          //  System.out.println("INSERT INTO t_ap_gd_hz (SELECT * FROM t_ap_location_hz19"+suffix+" WHERE locationType like '高德_%');");
          //  System.out.println("INSERT INTO t_ap_hz (device_id,ap_mac,ap_name,longitude,latitude,address,accuracy,locationType,from_phone) (SELECT device_id,ap_mac,ap_name,longitude,latitude,address,accuracy,locationType,from_phone FROM t_ap_location_hz19"+suffix+");");
        }
        for (String suf : days) {
           // 全天在线
            // System.out.println("insert into log_alldays(ap_mac,usr_mac) (SELECT ap_mac,usr_mac FROM gath_point2019"+suf+" GROUP BY ap_mac,usr_mac HAVING(count(1)>20)) on DUPLICATE key update days=1+days;");

            // 9-17在线
          //  System.out.println("insert into log_0917(ap_mac,usr_mac) (SELECT ap_mac,usr_mac FROM gath_point2019"+suf+" where date_hour>7 and date_hour<18 GROUP BY ap_mac,usr_mac HAVING(count(1)>5)) on DUPLICATE key update days=1+days;");
            // 24-5在线
            //System.out.println("insert into log_2405(ap_mac,usr_mac) (SELECT ap_mac,usr_mac FROM gath_point2019"+suf+" where date_hour<7 GROUP BY ap_mac,usr_mac HAVING(count(1)>4)) on DUPLICATE key update days=1+days;");
        }
        addCall0909();
        Object[] o= new Object[3];
        String res="";
        for(Object a:o){
            res+=a.toString();
        }
    }

    /**
     *  09/09  call添加
     */
    private static void addCall0909(){
        String[]suffixs =new String[]{"bj","ca","gs","jd","la","sc","tl","xc","xiaoshan","xiasha","xihu","yh"};
        for (String suffix : suffixs) {
          //System.out.println("CALL initTask('gath_hzsj_"+suffix+"', 'gath_hzsj.t_device_"+suffix+"', 'gath_hzsj.tlog_apl201909_"+suffix+"');");

          System.out.println("UPDATE t_ap_location_gath_hzsj_"+suffix+" SET apmac =  CONV(REPLACE(ap_mac,':',''),16,10) WHERE apmac is NULL; ");

         System.out.println("INSERT ignore INTO t_ap_location_20190917_baidu (device_id,apmac,ap_name,longitude,latitude,address,accuracy,locationType) SELECT device_id,apmac,ap_name,longitude,latitude,address,accuracy,locationType FROM t_ap_location_gath_hzsj_"+suffix+" WHERE locationType LIKE '百度%' AND (address not like '%浙江省杭州市余杭区文一西路%' and address is not null  );");
        System.out.println( "INSERT ignore INTO t_ap_location_20190917_gaode (device_id,apmac,ap_name,longitude,latitude,address,accuracy,locationType) SELECT device_id,apmac,ap_name,longitude,latitude,address,accuracy,locationType FROM t_ap_location_gath_hzsj_"+suffix+" WHERE locationType LIKE '高德%' AND (address not like '%浙江省杭州市余杭区文一西路%' and address is not null  );");
        }
    }


}
