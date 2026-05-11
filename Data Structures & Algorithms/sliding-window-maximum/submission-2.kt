class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        var pq = PriorityQueue<Pair<Int,Int>>(compareByDescending{it.second})
        var res = mutableListOf<Int>()
        var start = 0
        while(start<nums.size) {
           pq.add(Pair(start,nums[start]))
           if(start >= k-1) {
              while(pq.peek().first < start-(k-1)) {
                pq.poll()
              }
              res.add(pq.peek().second)
           }
           start ++
        }
        return res.toIntArray()
    }
}