class Solution {
    fun missingNumber(nums: IntArray): Int {
       var x = nums.size
       for(i in 0 until nums.size) {
          x = x xor i xor nums[i]
       }
       return x
    }
}