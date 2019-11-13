package javaBase;

/**
 * @author maple on 2019/11/12 16:21.
 * @version v1.0
 * @see 1040441325@qq.com
 */
public class TestExtendField {
    public static class A{
        int a;
        public void showA(){
            System.out.println(a);
        }
    }
    public static class B extends A{
        int a=1;

        public void showB(){
            System.out.println(a);
        }
    }
    public static void main(String[] args){
        A a=new A(){
            int a=1;
        };
        a.showA();
        System.out.println( a.a);
        B b= new B();
        b.showA();
        b.showB();
        System.out.println( ((A)b).a);
        System.out.println( b.a);

    }
}
