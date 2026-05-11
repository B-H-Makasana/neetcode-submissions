class Solution {
    fun partition(s: String): List<List<String>> {
        var res =  mutableListOf<List<String>>()
        var temp = mutableListOf<String>()
        fun dfs(index:Int) {
            if(index>=s.length) {
                res.add(temp.toList())
                return
            }
            for(j in index until s.length) {
                if(isPalindrome(s,index,j)) {
                    temp.add(s.substring(index,j+1))
                    dfs(j+1)
                    temp.removeLast()
                }
            }
        }
        dfs(0)
        return res
    }

    fun isPalindrome(s:String,i:Int,j:Int) : Boolean {
        var l = i
        var r = j
        while(l<r) {
            if(s[l]!=s[r]) {
                return false
            }
            l = l +1
            r = r-1
        }
        return true
    }
}
