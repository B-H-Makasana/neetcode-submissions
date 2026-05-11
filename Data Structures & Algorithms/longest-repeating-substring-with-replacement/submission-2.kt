class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var hashMap = HashMap<Char,Int>()
        var l = 0
        var r = 0
        var res = 0
        while(r<s.length) {
           hashMap.put(s[r],hashMap.getOrDefault(s[r],0)+1)
           var m = 0
           for((k_char,v) in hashMap) {
             m = max(m,v)
           }
           if((r-l+1) - m <=k) {
              res = max(res,r-l+1)
              r++
           } else {
             hashMap.put(s[l],hashMap.getOrDefault(s[l],1)-1)
             l++
             r++
           }
        }
        return res
    }
}