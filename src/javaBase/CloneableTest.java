package javaBase;

/**
 * @author maple on 2019/6/14 14:55.
 * @version v1.0
 * @see 1040441325@qq.com
 *
 * 使用native方式进行深度拷贝,提升性能
 * cloneable 接口是一个标记接口,用于native判断该类是否可进行深拷贝
 *
 */
public class CloneableTest {
    public static void main(String[] a) {
        B b = new B(2);
        B b1 = b.clone();
        System.out.println(b == b1);
        System.out.println(b.i == b1.i);
    }
}

class A implements Cloneable {
    int i;

    public A(int i) {
        this.i = i;
    }
}

class B implements Cloneable {
    int i;

    public B(int i) {
        this.i = i;
    }

    @Override
    protected B clone() {
        B b = null;
        try {
            b = (B) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return b;
    }

}
