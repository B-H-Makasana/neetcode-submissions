class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false
        var frq = IntArray(26)
        for(s in s1) {
            frq[s - 'a'] = frq[s - 'a'] + 1
        }
        var l = 0
        var r = s1.length - 1

        while(r<s2.length) {
             var temp  = IntArray(26)
            for(i in l..r) {
               temp[s2[i] - 'a'] = temp[s2[i] - 'a'] + 1
            }
            if(temp.contentEquals(frq)) {
                return true
            } else {
                l++
                r++
            }
        }
        return false
    }
}

