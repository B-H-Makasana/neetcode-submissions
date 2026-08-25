class Solution {
    fun hammingWeight(n: Int): Int {
       var res = 0
       var num = n
       while(num!=0) {
          res += num % 2
          num = num shr 1
       }
       return res
    }
}
