class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        var queue = mutableListOf<Pair<Int,Int>>()
        var freq = tasks.toList().groupingBy {it}.eachCount().values.toList()
        var heap = PriorityQueue<Int>(compareByDescending {it})

        var time = 0 
        freq.forEach { it ->
            heap.add(it)
        } 
        
        while(heap.isNotEmpty() || queue.isNotEmpty()) {
            time = time + 1
            var cnt = (heap.poll()?:0)  - 1
            if(cnt > 0) {
                queue.addLast(Pair(cnt,time + n))
            }
            if(queue.isNotEmpty() && queue[0].second <= time) {
                heap.add(queue[0].first)
                queue.removeAt(0)
            }
        }
        return time
    }
}
