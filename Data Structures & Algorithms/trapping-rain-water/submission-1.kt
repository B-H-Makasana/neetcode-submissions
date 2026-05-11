class Solution {
    fun trap(height: IntArray): Int {
         var prefix = IntArray(height.size)
         var suffix = IntArray(height.size)

         var leftMax = 0
         var rightMax = 0
         
         for (i in 0 until height.size) {
             leftMax = maxOf(leftMax, height[i])
             prefix[i] = leftMax
         }
         for (i in height.size - 1 downTo 0) {
             rightMax = maxOf(rightMax, height[i])
             suffix[i] = rightMax
         }

         var sum =0 
         for(i in 0..height.size-1){
            sum = sum + (min(prefix[i],suffix[i]) - height[i])
         }
         return sum
    }
}
