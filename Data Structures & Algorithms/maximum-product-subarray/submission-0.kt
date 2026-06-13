class Solution {
    fun maxProduct(nums: IntArray): Int {
    var res = nums.max() 
    var curMin = 1
    var curMax = 1 
      
    for(n in nums) {
       var temp = curMax * n 
       curMax = maxOf(curMax*n, curMin*n,n)
       curMin = minOf(temp, curMin*n,n)
       res = max(res,curMax)
    }

    return res
    }
}