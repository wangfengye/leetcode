package javaBase;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author maple on 2019/6/17 13:24.
 * @version v1.0
 * @see 1040441325@qq.com
 * 泛型实例化
 */
public class T2O {
    // json转字符
    private static <T> T j2o(Class<T> c, String data) {
        T t = null;
        try {
            t = c.newInstance();
            data = data.substring(data.indexOf('{') + 1, data.lastIndexOf('}'));
            String[] fields = data.split(",");
            for (String field : fields) {
                String[] tmp =new String[2];
                int id = field.indexOf(':');
                tmp[0]=field.substring(0,id);
                tmp[1]=field.substring(id+1);
                Field f = c.getDeclaredField(tmp[0]);
                if (tmp[1].charAt(0)=='{'){
                    Class filedType = f.getType();
                    f.set(t,j2o(filedType,tmp[1]));
                }
                else if (tmp[1].charAt(0) == '"') {
                    f.set(t, tmp[1].substring(1, tmp[1].length() - 1));
                } else if (tmp[1].equals("true")) {
                    f.setBoolean(t, true);
                } else if (tmp[1].equals("false")) {
                    f.setBoolean(t, false);
                } else if (f.getType() == double.class) {
                    f.setDouble(t, Double.parseDouble(tmp[1]));
                } else if (f.getType() == int.class) {
                    f.setInt(t, Integer.parseInt(tmp[1]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    // 字符串装json
    private static String o2j(Object o) {
        StringBuilder builder = new StringBuilder();
        builder.append('{');
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field f : fields) {
            try {
                builder.append(f.getName()).append(":");
                if (f.getType() == String.class) {
                    builder.append('"').append(f.get(o)).append('"').append(',');
                }else if (isBaseClass(f.getType())){
                    builder.append(f.get(o)).append(",");
                }else {
                    builder.append(o2j(f.get(o)));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        builder.setLength(builder.length() - 1);
        builder.append('}');
        return builder.toString();
    }

    private static boolean isBaseClass(Class<?> type) {
        if (type==int.class||type==long.class||type==double.class||type==float.class)return true;
        return false;
    }

    static class A {
        int count;
        String name;
        B b;

    }
    static class B{
        double per;
    }

    public static void main(String[] args) {
        A a = j2o(A.class, "{count:1,name:\"maple\",b:{per:1.1}}");
        System.out.println(o2j(a));
        System.out.println(int.class instanceof Object);
    }
}
