class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
         var k = piles.max()!!
         if(piles.size == h) {
            return k
         }
         var low = 1
         var high = k
         var res = high
         while(low<=high) {
             val k = low + (high-low)/2
             var time = 0L
             for(p in piles) {
                time += Math.ceil(p.toDouble()/k).toLong()
             }
             if(time <= h) {
                res = k
                high = k - 1
             } else {
                low = k + 1
             }
         }
         return res
    }
}
