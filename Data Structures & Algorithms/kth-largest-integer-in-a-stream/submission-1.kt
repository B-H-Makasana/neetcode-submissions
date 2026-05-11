class KthLargest(k: Int, nums: IntArray) {
    var pq = PriorityQueue<Int>()
    var k = k
    init {
      nums.forEach { it ->
        pq.add(it)
      }
      while(pq.size >this.k) {
            pq.poll()
      }
    }
    fun add(`val`: Int): Int {
        pq.add(`val`)
        if(pq.size > k) {
            pq.poll()
        }
        return pq.peek()
    }
}
