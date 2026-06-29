class Solution {
    fun maxProfit(prices: IntArray): Int {
        var dp = HashMap<Pair<Int,Boolean>,Int>()
        
        fun dfs(i:Int,buying:Boolean) : Int {
            if(i >= prices.size) {
                return 0
            }
            if(Pair(i,buying) in dp) {
                return dp[Pair(i,buying)]!!
            }
            var cooling = dfs(i+1,buying) 
            if(buying) {
               var buy = dfs(i+1,!buying) - prices[i]
               dp[Pair(i,buying)] = max(buy,cooling)  
            } else {
                var sell = dfs(i+2,!buying) + prices[i]
                dp[Pair(i,buying)] = max(sell,cooling)  
            }
            return dp[Pair(i,buying)]!!    
        }

        return dfs(0,true)
    }
}