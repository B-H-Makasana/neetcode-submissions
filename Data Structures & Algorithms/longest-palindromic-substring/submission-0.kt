class Solution {
    fun longestPalindrome(s: String): String {

      var res = ""
      
      for(i in s.indices) {
        //  if(s.length % 2 != 0) {
         var l = i
         var r = i
         while(l>=0 && r < s.length && s[l] == s[r]) {
            if(r-l+1>res.length) {
              res = s.substring(l,r+1)
            }
            l--
            r++
         }
        //  } else {
        l = i
        r = i + 1
         while(l>=0 && r < s.length && s[l] == s[r]) {
            if(r-l+1>res.length) {
              res = s.substring(l,r+1)
            }
            l --
            r ++
         }
         }
      // }
      return res
    }
}