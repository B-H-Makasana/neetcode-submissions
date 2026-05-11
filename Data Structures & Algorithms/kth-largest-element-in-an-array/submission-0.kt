class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
       var pq = PriorityQueue<Int> ()
       nums.forEach {
         pq.add(it)
         if(pq.size>k){
            pq.poll()
         }
       }
       return pq.peek()
    }
}
