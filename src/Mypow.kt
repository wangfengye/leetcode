import com.sun.xml.internal.fastinfoset.util.StringArray

class Mypow {
    fun myPow(x: Double, n: Int): Double {
        if (n == 0) return 1.0;
        if(n==Int.MIN_VALUE){//Int最小值取反超出int上限
            return 1 / (pow(x, -(n+2))*x*x)
        }
        return if (n < 0) 1 / pow(x, -n) else pow(x, n);
    }

    private fun pow(x: Double, n: Int): Double {
        println(n);
        if (n == 1) return x;
        val tmp = pow(x, n / 2);
        return if (n % 2 == 0) tmp * tmp else tmp * tmp * x;
    }

    companion object {
        @JvmStatic
        public fun main(args: Array<String>) {
           // print(Mypow().myPow(1.0, -2147483648))
            System.out.println(Int.MIN_VALUE)
            System.out.println(-Int.MIN_VALUE)
            System.out.println(Int.MAX_VALUE)
            System.out.println(-Int.MAX_VALUE)
        }
    }
}