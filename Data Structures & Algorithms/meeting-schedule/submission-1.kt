/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun canAttendMeetings(intervals: List<Interval>): Boolean {
        if(intervals.isEmpty()) {
            return true
        }
        val sorted = intervals.sortedBy { it.start }
        var prevEnd = sorted[0].end

        for(i in 1 until sorted.size) {
            if(sorted[i].start < prevEnd) {
                return false
            }
            prevEnd = sorted[i].end
        }
        return true
    } 
}
