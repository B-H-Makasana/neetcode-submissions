class Solution {
    fun countSubstrings(s: String): Int {
        var res = 0
        for(i in s.indices) {
           var l = i
           var r = i

           while(l >= 0 && r < s.length && s[l] == s[r]) {
              l--
              r++
              res ++
           }

           l = i
           r = i + 1

           while(l >= 0 && r < s.length && s[l] == s[r]) {
              l--
              r++
              res++
           }
        }
        return res
    }
}
