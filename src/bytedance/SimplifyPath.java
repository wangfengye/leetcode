package bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maple on 2019/2/18 13:58.
 * @version v1.0
 * @see 1040441325@qq.com
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * <p>
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 * <p>
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        StringBuilder builder = new StringBuilder();
        int index = 0;
        while (index < path.length()) {
            char temp = path.charAt(index);
            if (temp == '.') {
                int point = index + 1;
                while (point<path.length()&&path.charAt(point) != '/') {
                    point++;
                }
                if (point - index == 1){}
                else if (point - index == 2&&path.charAt(index+1)=='.') {// .. 表示返回上一级
                    if (builder.length() > 1) {
                        builder.deleteCharAt(builder.length() - 1);
                        while (builder.charAt(builder.length() - 1) != '/') {
                            builder.deleteCharAt(builder.length() - 1);
                        }
                    }
                } else {//直接拼接
                    for (int i = index; i < point; i++) {
                        builder.append(path.charAt(i));
                    }
                }
                index = point - 1;
            } else if (temp == '/') {
                if (builder.length() < 1 || builder.charAt(builder.length() - 1) != '/') {    //重复'/'不需添加;末尾不需要'/'
                    builder.append(temp);
                }
            } else {

                while (index<path.length()&&path.charAt(index)!='/'){
                    builder.append(path.charAt(index));
                    index++;
                }
                index--;
            }
            index++;
        }
        if (builder.length() > 1 && builder.charAt(builder.length() - 1) == '/')
            builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
    public String simplifyPath2(String path) {
        String[] paths = path.split("/");

        List<String> listPath = new ArrayList<>();

        for (String p: paths) {
            // System.out.println(":" + p);
            if (p == null || p.equals("") || p.equals(".")) {
                continue;
            }

            if (!p.equals("..")) {
                listPath.add(p);
            } else if (listPath.size() > 0) {
                listPath.remove(listPath.size() - 1);
            }
        }

        if (listPath.size() == 0) {
            return "/";
        }

        StringBuilder res = new StringBuilder();
        for (String p : listPath) {
            res.append("/").append(p);
        }

        return res.toString();
    }
}
