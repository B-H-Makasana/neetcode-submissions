class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
       var l = 0
       var r = 0
       var res = 0

       var hashMap = HashMap<Char,Int>()
       while(r<s.length) {
           var temp  = hashMap.getOrDefault(s[r],0)
           if(temp>0) {
              hashMap.remove(s[l])
              l++
           } else {
              hashMap.put(s[r],1)
              r++
              res = max(r-l,res)
           }
       }
       return res
    }
}
