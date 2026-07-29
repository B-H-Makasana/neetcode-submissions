class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
         intervals.sortBy { it[0] }
         var res = mutableListOf<IntArray>()
         var last = intervals[0]

         for(i in 1 until intervals.size) {
            if(last[1] < intervals[i][0]) {
                res.add(last)
                last = intervals[i]
            } else {
                last[0] = min(last[0],intervals[i][0])
                last[1] = max(last[1],intervals[i][1])
            }
         }
         res.add(last)
         return res.toTypedArray()
    }
}
