class Solution {
    fun minWindow(s: String, t: String): String {
        if(t == "") return ""
        var tMap = HashMap<Char,Int>()

        for(c in t) {
            tMap[c] = tMap.getOrDefault(c,0) + 1
        }

        var window = HashMap<Char,Int>()
        var resLen = IntArray(2){-1}
        var res = Int.MAX_VALUE 
        var l = 0
        var have = 0
        var need = t.length

        for(r in s.indices) {
           var c = s[r]
           window[c] = window.getOrDefault(c,0) + 1
           if(t.contains(c) && window[c]!! <= tMap[c]!!) {
              have ++
           }

            while(have == need) {
                if(r-l+1 < res) {
                    res = r-l+1
                    resLen[0]=l
                    resLen[1]=r+1
                }
                window[s[l]] = window.getOrDefault(s[l],1) - 1
                if(t.contains(s[l]) && window[s[l]] ?:0 < tMap[s[l]]!!) {
                    have--
                }
                l++
            }
        }

        if(res !=  Int.MAX_VALUE) {
            return s.substring(resLen[0],resLen[1])
        } else {
            return ""
        }
    }
}
