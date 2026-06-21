class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
       var raw = IntArray(n) {1}
       for(i in 0 until m-1) {
         var newRaw = IntArray(n) {1}
         for(j in n - 2 downTo 0) {
           newRaw[j] = newRaw[j+1] + raw[j] 
         }
         raw = newRaw
       }
       return raw[0]
    }
}