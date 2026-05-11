class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
         var max = 0
         var stack = mutableListOf<Pair<Int,Int>>()

        for(i in 0..heights.size-1) {
            var start = i
            while(stack.isNotEmpty() && stack.last().second > heights[i]) {
                val top = stack.size - 1
                max = maxOf(max,(i-stack[top].first) * stack[top].second)
                start = stack[top].first
                stack.removeLast()
            }
            stack.add(Pair(start,heights[i]))
        }
        for((i,h) in stack) {
                max = maxOf(max,(heights.size-i) * h)
            }
        return max
    }
}
