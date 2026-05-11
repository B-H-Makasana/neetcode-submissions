class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
       var stack = mutableListOf<Int>()
       var res = IntArray(temperatures.size){0}
       for(temp in 0 until temperatures.size) {
           while(stack.isNotEmpty() && temperatures[stack.last()] < temperatures[temp]) {
               var stackIndex = stack.removeAt(stack.size-1)
               res[stackIndex] = temp - stackIndex 
            }
            stack.add(temp)
        }
       return res
    }
}
