class Solution {
    fun isHappy(n: Int): Boolean {
      var seen = mutableSetOf<Int>()
  
      var num = n

      while(num  !in seen) {
          var c = num
          var res  = 0
          while(c > 0) {
            var d = c % 10
            res += (d*d)
            c = c/10
          } 
          if(res == 1) {
            return true
          } else {
            seen.add(num)
          }
          num = res
      }
      return false
      
    }
}
