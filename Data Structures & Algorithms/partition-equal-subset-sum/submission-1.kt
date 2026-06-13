class Solution {
    fun canPartition(nums: IntArray): Boolean {

       var target = nums.sum() / 2

       if(nums.sum() %2 !=0 ) return false

       var dp = HashSet<Int>()
       dp.add(0)
       for(num in nums) {
          var temp = HashSet<Int>()
          for(t in dp) {
             temp.add(t+num)
             temp.add(t)
          }
          dp = temp
       }
       return dp.contains(target)
    }
}
