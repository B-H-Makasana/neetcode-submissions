class Solution {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        if(s1.length + s2.length != s3.length) {
            return false
        }
    
        var dp = Array(s1.length + 1) {BooleanArray(s2.length + 1) {false}}
        dp[s1.length][s2.length] = true
        for(i in s1.length downTo 0) {
            for(j in s2.length downTo 0) {
                if((i < s1.length) && s1[i] == s3[i+j] && dp[i+1][j]) {
                   dp[i][j] = true
                }
                if((j < s2.length) && s2[j] == s3[i+j] && dp[i][j+1]) {
                   dp[i][j] = true
                }
            }
        }
        
        return dp[0][0]
    }
}
