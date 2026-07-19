class Solution {
    fun maxSubArray(nums: IntArray): Int {
         var res = nums[0]
         var cur = 0

         for(i in nums) {
            if(cur<0) {
                cur = 0
            }
            cur += i
            res = max(res,cur)
         }
         return res
    }
}
