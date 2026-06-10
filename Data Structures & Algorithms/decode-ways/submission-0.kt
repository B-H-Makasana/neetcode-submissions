class Solution {
    fun numDecodings(s: String): Int {
        var dp = mutableMapOf(s.length to 1)

        for(i in s.length-1 downTo 0) {
            if(s[i] == '0') {
                dp[i] = 0
            } else {
                dp[i] = dp[i+1] ?: 0

                if(i+1 < s.length && (s[i] == '1' || (s[i] == '2' && s[i+1] <= '6'))) {
                    dp[i] = dp[i]!! + (dp[i+2] ?: 0)
                }
            }
        }
        return dp[0] ?: 0
    }
}
