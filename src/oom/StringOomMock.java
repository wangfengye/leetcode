package oom;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author maple on 2020/1/13 11:48.
 * @version v1.0
 * @see 1040441325@qq.com
 */
public class StringOomMock {
    static String base = "string";

    public static void main(String[] args) {
        testFinalStringOOM();
        for (; ; ) {
            int i = 1;

            for (int j = 0; j < 10; j++) {
                if (i == 9) System.gc();
                i++;
            }

        }
        //testClassLoader();
    }

    private static void testFinalStringOOM() {
        //由报错可知常量区转移到堆内存
        for (int i = 0; i < 15; i++) {
            String s = base + base;
            base = s;
            //intern 方法会从字符串常量池中查询当前字符串是否存在，若不存在就会将当前字符串放入常量池中
            s.intern();
        }
    }

    public static void testClassLoader() {
        //模拟类溢出,1.7会包永久代异常(要把永久代设很小)
        URL url = null;
        List<ClassLoader> classLoaderList = new ArrayList<ClassLoader>();
        try {
            url = new File("/tmp").toURI().toURL();
            URL[] urls = {url};
            while (true) {
                ClassLoader loader = new URLClassLoader(urls);
                classLoaderList.add(loader);
                loader.loadClass("AddBinary");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
