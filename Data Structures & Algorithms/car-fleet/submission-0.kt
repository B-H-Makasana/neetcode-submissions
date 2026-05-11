class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
         val pair = position.zip(speed).sortedByDescending { it.first }
         val stack = mutableListOf<Double>() 
         for((p,s) in pair) {
            val time : Double= ((target-p).toDouble() / s)
             stack.add((time))
             if(stack.size >=2 && stack[stack.size-1] <= stack[stack.size-2]) {
                stack.removeLast()
             }
         }
         return stack.size
    }
}
