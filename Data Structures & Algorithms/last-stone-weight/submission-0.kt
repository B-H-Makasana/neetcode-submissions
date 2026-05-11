class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
       var pq = PriorityQueue<Int>(compareByDescending { it })
       stones.forEach {
         pq.add(it)
       }

       while(pq.size >1) {
          var x = pq.poll()
          var y = pq.poll()
          if(x!=y) {
            pq.add(abs(x-y))
          }
       }
       if(pq.size == 0) {
        return 0
       } else {
        return pq.poll()
       }
    }
}
