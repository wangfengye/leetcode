package classLoader;

import org.bouncycastle.crypto.agreement.jpake.JPAKERound1Payload;
import sun.misc.ClassLoaderUtil;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 模拟jsp热更新
 */
public class Main {

    static MyLoader parent;

    public static void main(String[] args) throws Exception {
        parent = new MyLoader("D:\\classloader\\v1\\");
        parent.loadClass("java.lang.String");
        test();
        parent=new MyLoader("D:\\\\classloader\\\\v2\\\\");
        test();
        test();
    }
    public static void test()throws Exception{
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
        HashMap<String,Class<?>> set=new HashMap<>();
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            if(set.containsKey(name))return set.get(name);
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
                set.put(name,defineClass(classBytes, 0, classBytes.length));
                return set.get(name);
            } catch (Exception e) {
                e.printStackTrace();
                return super.findClass(name);
            }

        }
    }
}
