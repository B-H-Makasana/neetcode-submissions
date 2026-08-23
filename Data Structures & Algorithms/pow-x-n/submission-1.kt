class Solution {
    fun myPow(x: Double, n: Int): Double {
       var res = 1.0
        if (x == 0.0) {
            return 0.0
        }
        if (n == 0) {
            return 1.0
        }

        var base = x
        var power = Math.abs(n.toLong())
        while(power > 0) {
            if(power % 2 == 1L) {
                res *=base
            }
            base*=base
           power =  power / 2
        }  
        
       return if(n>=0)  res else 1/res
    }
}
