class Solution {
    var res = mutableSetOf<List<Int>>()
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        backTrack(nums,0,mutableListOf())
        return res.toList()
    }

    fun backTrack(nums: IntArray,index:Int,current:MutableList<Int>) {
        if(index >= nums.size) {
          res.add(current.toList().sorted())
          return
        }
        current.add(nums[index])
        backTrack(nums,index+1,current)
        current.removeLast()
        backTrack(nums,index+1,current)
    }
}
