class Solution {
    fun reverse(x: Int): Int {
       var min = Int.MIN_VALUE
       var max =Int.MAX_VALUE
       var res = 0 
       var num = x
       while(num != 0) {
          var digit = num % 10
          num = num / 10

          if(res > max/10 || (res == max/10 && digit> max%10)) {
            return 0
          }
          if(res < min/10 || (res == min/10 && digit< min%10)) {
            return 0
          }
          res = res * 10 + digit
       }
       return res
    }
}
