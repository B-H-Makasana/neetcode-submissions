class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
       var dp = cost + 0 
       for(i in dp.size - 3 downTo 0) {
          dp[i] = dp[i] + min(dp[i+1],dp[i+2])
       }
       return min(dp[0],dp[1])
    }
}
