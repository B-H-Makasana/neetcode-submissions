class Solution {
    fun numDistinct(s: String, t: String): Int {
       var dp = HashMap<Pair<Int, Int>, Int>()
       
       fun dfs(i:Int,j:Int) : Int {
         if(j == t.length) {
            return 1
          }

          if(i == s.length) {
             return 0
          }
          
          dp[i to j]?.let { return it }

           
          if(s[i] == t[j]) {
             dp[i to j] = dfs(i+1,j+1) + dfs(i+1,j)
          } else {
             dp[i to j] = dfs(i+1,j)
          }
          return dp[i to j]!!
        }
        
        return dfs(0,0)
    }
}
