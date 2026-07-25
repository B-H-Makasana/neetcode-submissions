class Solution {
    fun jump(nums: IntArray): Int {
        var res = 0
        var l = 0
        var r = 0
        while(r< nums.size - 1) {
            var far = 0 
            for(i in l until r+1) {
               far = max(far,i+nums[i])
            }
            l = r + 1
            r = far
            res++
        }
        return res
    }
}
