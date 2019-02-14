package javaBase;

import java.lang.reflect.Field;

/**
 * @author maple on 2019/2/13 17:40.
 * @version v1.0
 * @see 1040441325@qq.com
 * 枚举类,反射获取字段
 */
public class EnumDemo {
    enum Color {
        RED("红色"), GREEN("绿色");
        private String name;
        protected String pro = "protected";
        String def = "default";
        public String pub = "public";

        public String getName() {
            return name;
        }

        private Color(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        //System.out.println(Color.RED.name);
        show(Color.values());

    }

    private static void show(Enum<?>[] colors) {
        for (Enum color :
                colors) {
            Class cls = color.getClass();
            Field[] f = cls.getDeclaredFields();//所有声明的变量
            //Field[] f = cls.getFields();//只获取public的变量
            for (Field field : f) {
                field.setAccessible(true);
                try {
                    // 排除公共字段: 枚举实例集合"$VALUES" 和枚举实例
                    if (field.getName().equals("$VALUES") || field.getType().isEnum()) continue;

                    System.out.println(field.getName() + ":" + field.get(color));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
