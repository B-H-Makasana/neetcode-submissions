class Solution {

    fun rob(nums: IntArray): Int {
    
      fun houseRob(nums:IntArray) : Int {
        if (nums.isEmpty()) {
            return 0
        }
        if(nums.size == 1) {
          return nums[0]
        }  
        if(nums.size == 2) {
          return max(nums[0],nums[1])
        }
        nums[1] = max(nums[0],nums[1])
        for(i in 2 until nums.size) {
          nums[i] = maxOf(nums[i-1],  nums[i] + nums[i-2])
        }
        return nums[nums.size -1]
      }
        if(nums.size == 1) {
          return nums[0]
        }  
 
     return maxOf(houseRob(nums.copyOfRange(0,nums.size-1)),houseRob(nums.copyOfRange(1,nums.size)))

    }
}