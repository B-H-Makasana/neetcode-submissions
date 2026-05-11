class Solution {
      var res = mutableListOf<List<Int>>()
  
    fun permute(nums: IntArray): List<List<Int>> {
      backTrack(nums,mutableListOf(),BooleanArray(nums.size))
      return res
    }
    fun backTrack(nums:IntArray,current:MutableList<Int>,track:BooleanArray) {
        if(current.size >= nums.size) {
            res.add(current.toList())
        }
        for(i in nums.indices) {
            if(!track[i]) {
            current.add(nums[i])
            track[i] = true
            backTrack(nums,current,track)
            current.removeLast()
            track[i] = false
           }
        }        
      }
}