/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun minMeetingRooms(intervals: List<Interval>): Int {
         var start = intervals.map {it.start}.sorted()
         var end = intervals.map {it.end}.sorted()

         var res = 0
         var count = 0

         var s = 0
         var e = 0

         while(s<start.size) {
            if(start[s] < end[e]) {
                s++
                count ++
            } else {
                e++
                count--
            }
            res = max(res,count)
         }
         return res
    }
}