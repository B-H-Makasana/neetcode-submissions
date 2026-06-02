class Solution {
    fun rob(nums: IntArray): Int {
      if(nums.size == 1) {
        return nums[0]
      }  
      if(nums.size == 2) {
        return max(nums[0],nums[1])
      }
      nums[1] = maxOf(nums[0],nums[1])
      for(i in 2 until nums.size) {
        nums[i] = maxOf(nums[i-1],  nums[i] + nums[i-2])
      }
      return nums[nums.size -1]
    }
}