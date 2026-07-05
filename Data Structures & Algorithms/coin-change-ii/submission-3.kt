class Solution {
    fun change(amount: Int, coins: IntArray): Int {
      var cache = Array(coins.size+1) { IntArray(amount+1) {-1} }
      fun dfs(sum:Int,i:Int) : Int {
         if(sum == amount) {
            return 1
         }  
         if (sum > amount || i >= coins.size) {
            return 0
         }
         if(cache[i][sum] != -1) {
            return cache[i][sum]
         }
         cache[i][sum] = dfs(sum+coins[i],i) + dfs(sum,i+1) 
         return cache[i][sum]
        }

        return dfs(0,0)
    }
}