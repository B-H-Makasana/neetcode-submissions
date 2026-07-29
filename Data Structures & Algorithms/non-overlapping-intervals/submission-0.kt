class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
         intervals.sortBy {
            it[0]
         }
         var prev = intervals[0][1]
         var count = 0
         for(j in 1 until intervals.size) {
            var i = intervals[j]
            if(i[0]>=prev) {
                prev = i[1]
            } else {
                prev = min(prev,i[1])
                count++
            }
         }
         return count
    }
}
