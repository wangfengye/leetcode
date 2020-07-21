package classLoader;



import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

/**
 * 模拟jsp热更新
 */
public class Main {

    static MyLoader parent;

    public static void main(String[] args) throws Exception {
        int[][] data=new int[7][7];
        int start=4;
        int add=1;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < 7 - start; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < start; j++) {
                System.out.print(data[i][j]+" ");
            }
            if(start==7)add=-1;
            start+=add;
            System.out.println();
        }
        if (true)return;
        parent = new MyLoader("D:\\classloader\\v1\\");

        parent.loadClass("java.lang.String");
        test();
        //父ClassLoader 无法拿到子ClassLoader 加载的类
        try {
            Class<?> t = Class.forName("classLoader/Test");
            Method m = t.getMethod("test");
            m.invoke(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        parent = new MyLoader("D:\\\\classloader\\\\v2\\\\");
        test();
        test();
        //加载类列表
        ClassLoader appClassLoader = Main.class.getClassLoader();
        System.out.println(appClassLoader.getClass().getName());
        list(appClassLoader);
    }

    private static void list(ClassLoader CL)
            throws NoSuchFieldException, SecurityException,
            IllegalArgumentException, IllegalAccessException {
        Class CL_class = CL.getClass();
        while (CL_class != java.lang.ClassLoader.class) {
            CL_class = CL_class.getSuperclass();
        }
        java.lang.reflect.Field ClassLoader_classes_field = CL_class
                .getDeclaredField("classes");
        ClassLoader_classes_field.setAccessible(true);
        Vector classes = (Vector) ClassLoader_classes_field.get(CL);
        Iterator it = classes.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            System.out.println(o.toString());
        }
    }
    private static void showClass(){

    }


    public static void test() throws Exception {
        Class<?> t = parent.loadClass("Test");
        Method m = t.getMethod("test");
        m.invoke(null);
    }

    static class MyLoader extends ClassLoader {
        private String path;

        public MyLoader(String path) {
            super();
            this.path = path;
        }

        public MyLoader(String path, ClassLoader loader) {
            super(loader);
            this.path = path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        //防止重复加载的逻辑自己想的,源码可能有更好的方式.
        HashMap<String, Class<?>> set = new HashMap<>();

        @SuppressWarnings("all")
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            System.out.println("sas, "+name);
            if (set.containsKey(name)) return set.get(name);
            try {
                FileInputStream in = new FileInputStream(path + name + ".class");
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int len = -1;
                while ((len = in.read(buf)) != -1) {
                    baos.write(buf, 0, len);
                }
                in.close();
                byte[] classBytes = baos.toByteArray();
                set.put(name, defineClass(classBytes, 0, classBytes.length));
                return set.get(name);
            } catch (Exception e) {
                e.printStackTrace();
                return super.findClass(name);
            }

        }
    }
}
