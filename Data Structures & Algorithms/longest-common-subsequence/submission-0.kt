class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        var r = text1.length  
        var c = text2.length 

        var dp = Array(r+1) {IntArray(c+1)}

        for(i in r-1 downTo 0) {
            for(j in c-1 downTo 0) {
                if(text1[i] == text2[j]) {
                    dp[i][j] = dp[i+1][j+1] + 1
                } else {
                    dp[i][j] = max(dp[i+1][j],dp[i][j+1])
                }
            }
        }
        return dp[0][0]
    }
}
