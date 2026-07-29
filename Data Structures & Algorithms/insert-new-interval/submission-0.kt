class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        var res = mutableListOf<IntArray>()
        for(i in intervals) {
            if(newInterval[1] < i[0]) {
                res.add(newInterval)
                return (res + intervals.sliceArray(intervals.indexOf(i) until intervals.size)).toTypedArray()
            } else if(newInterval[0] > i[1]) {
                res.add(i)
            }  else {
               newInterval[0] = min(i[0],newInterval[0])
               newInterval[1] = max(i[1],newInterval[1]) 
            }
        }
        res.add(newInterval)
        return res.toTypedArray()
    }
}
