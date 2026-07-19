class Solution {
    fun maxCoins(nums: IntArray): Int {
      var nums = intArrayOf(1) + nums + intArrayOf(1)
      val dp = Array(nums.size) { IntArray(nums.size) }

      fun dfs(l:Int,r:Int) : Int {
         if(l > r) {
            return 0
         }
         if(dp[l][r] > 0) {
            return dp[l][r]
         }

         for(i in l until r+1) {
            var coins = nums[l-1] * nums[i] * nums[r+1]
            coins += dfs(l,i-1) + dfs(i+1,r)
            dp[l][r] = max(dp[l][r],coins)
          }
         return dp[l][r]
      }
       return dfs(1,nums.size - 2)
    }
}