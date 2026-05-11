class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
      val res = mutableListOf<List<Int>>()
      val sumList = mutableListOf<Int>()

      fun backTrack(i:Int,total:Int) {
         if(i == nums.size || total > target)  {
            return
         } 
         if(total == target) {
            res.add(sumList.toList())
            return
         }

             sumList.add(nums[i])
             backTrack(i,total+nums[i])
             sumList.removeLast()
             backTrack(i+1,total)
           
      }       
      backTrack(0,0)
      return res
    }
}
