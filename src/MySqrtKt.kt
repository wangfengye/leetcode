class MySqrtKt {
    fun mySqrt(x: Int): Int {
        if (x == 0) return 0
        if (x < 4) return 1
        var r = x / 2
        while (r > x / r) {
            r = (r + x / r) / 2
        }
        return r
    }
}