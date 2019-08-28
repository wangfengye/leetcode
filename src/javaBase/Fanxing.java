package javaBase;

/**
 * @author maple on 2019/8/22 15:07.
 * @version v1.0
 * @see 1040441325@qq.com
 */
public class Fanxing {
    public static void main(String[] args) {
        new A().show(new O<P>());
        //new A().show(new O<PP>());
        new A().show(new O<C>());
        new A().show2(new O<P>());
        new A().show2(new O<PP>());
        // new A().show2(new O<C>());


    }

    static class A {
        void show(O<? extends P> p) {
            System.out.println("extends");
        }

        void show2(O<? super P> p) {
            System.out.println("super");
        }


    }

    static class O<T> {

    }

    static class PP {

    }

    static class P extends PP {

    }

    static class C extends P {

    }
}
