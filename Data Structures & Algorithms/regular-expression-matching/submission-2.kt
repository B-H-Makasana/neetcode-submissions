class Solution {
    fun isMatch(s: String, p: String): Boolean {
        var dp = HashMap<Pair<Int,Int>,Boolean>() 
        fun dfs(i:Int,j:Int) : Boolean {
            if(dp[Pair(i,j)] != null) {
                return dp[Pair(i,j)]!!
            }

            if(j >= p.length  && i>=s.length) {
                return true
            }
            if(j>=p.length) {
                return false
            }
            val match = (i<s.length && (s[i] == p[j] || p[j] == '.'))
        
            if(j+1 < p.length && p[j+1] == '*') {
               dp[Pair(i,j)] =  dfs(i,j+2) || (match && dfs(i+1,j)) 

               return dp[Pair(i,j)]!!
            }
            if (match) {
                dp[Pair(i,j)] = dfs(i+1,j+1)
                return dp[Pair(i,j)]!!
            }
            dp[Pair(i,j)] = false
            return false
        }
        
        return dfs(0,0)
    }
}
