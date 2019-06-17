package javaBase;

import java.lang.reflect.Field;

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
            data = data.substring(data.indexOf('{') + 1, data.indexOf('}'));
            String[] fields = data.split(",");
            for (String field : fields) {
                String[] tmp = field.split(":");
                Field f = c.getDeclaredField(tmp[0]);
                if (tmp[1].charAt(0) == '"') {
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
                } else builder.append(f.get(o)).append(",");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        builder.setLength(builder.length() - 1);
        builder.append('}');
        return builder.toString();
    }

    static class A {
        int count;
        String name;

    }

    public static void main(String[] args) {
        A a = j2o(A.class, "{count:1,name:\"maple\"}");
        System.out.println(o2j(a));
    }
}
