class Solution {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0
        var minPrice = prices[0]
        for(i in prices) {
           if(i>minPrice) {
             profit = max(profit, i - minPrice)
           } else {
             minPrice = min(minPrice,i)
           }
        }
        return profit
    }
}
