class Solution {
    fun findMin(nums: IntArray): Int {
        if(nums.size == 1) {
            return nums[0]
        }
        if(nums[0] < nums[nums.size-1]) {
            return nums[0]
        } 
        for(i in 0..nums.size-1) {
            if(nums[i] > nums[i+1]) {
                 return nums[i+1]
            }
        }        
        return 0
    }
}
