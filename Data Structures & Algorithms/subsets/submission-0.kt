class Solution {
    var resList = mutableListOf<List<Int>>()
    fun subsets(nums: IntArray): List<List<Int>> {
        
        backTrack(nums,mutableListOf(),0)
        return resList
    }

    fun backTrack(nums:IntArray,current:MutableList<Int>,index:Int) {
            if(index >= nums.size) {
                resList.add(current.toList())
                return 
            }
            current.add(nums[index])
            backTrack(nums,current,index+1)
            current.removeLast()
            backTrack(nums,current,index+1)
    }
}
