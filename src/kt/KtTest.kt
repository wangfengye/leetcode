package kt

import jdk.nashorn.internal.objects.Global.print

class KtTest {
    constructor(a:Int){
        mA=a;
    }
    var mA:Int=1
        get()=field+1
    val fA:Int=2;

    fun sum(a: Int, b: Int): Int {
        return a + b;
    }

    public fun sum1(a: Int, b: Int): Int = a + b;
    public fun show(a: Int, b: Int):Unit{
        print(a+b);
    }
    public fun showAll(args:Array<Int>){
        for(arg in args){
            print(arg);
        }
    }
    fun showLambda(){
        val sum:(Int,Int)->Int={x,y->x+y}
        print(sum(1,1));
    }

    fun testNUll(a:String?){
        println(a?.toString())
    }
    companion object{
        @JvmStatic
        public fun main(args:Array<String>){
            val t=KtTest(1);
            println(t.mA);
            t.testNUll("ab");
            t.testNUll(null);
            t.mCallback= object : Callback {
                override fun onSuccess() {
                    print("success");
                }
            }
        }
    }
     var mCallback:Callback=object :Callback{
         override fun onSuccess() {
             //default do nothing
         }
     };
    interface Callback{
        fun onSuccess();
    }

}