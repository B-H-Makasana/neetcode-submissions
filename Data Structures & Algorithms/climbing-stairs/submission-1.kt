class Solution {
    fun climbStairs(n: Int): Int {
       var n1 = 1
       var n2 = 1
       
       for(i in 0..n-2) {
         var temp =  n1 
         n1 = n1 + n2
         n2 = temp
       }
       return n1
    }
}