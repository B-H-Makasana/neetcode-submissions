class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
       var dp = IntArray(nums.size) {1}

       for(i in 0 until nums.size) {
          for(j in i downTo 0) {
             if(nums[j] < nums[i]) {
                dp[i] = max(dp[i],1 + dp[j])
             }
          }
       }

       return dp.max()
    }
}
