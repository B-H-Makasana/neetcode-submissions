class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        var map = HashMap<Int,MutableList<Pair<Int,Int>>>()
        var visited = mutableSetOf<Int>()
        var maxTime = 0 
        for(i in 1 until n+1) {
            map[i] = mutableListOf()
        }
        for(time in times) {
            map[time[0]]!!.add(Pair(time[1],time[2]))
        }
        for((key,value) in map) {
            println("key is $key value is $value")
        }
        val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        minHeap.offer(Pair(k,0))
        while(minHeap.isNotEmpty()) {
            val node = minHeap.poll()
            
            var time = node.second
            var v = node.first
            println(" node is $v and $time")
            println(visited.joinToString())
            if(visited.contains(v)) {
                 continue
            }
            visited.add(v)

            maxTime = time
            println("time is $maxTime")
            for(n in map[v] ?: mutableListOf()) {
               if(!visited.contains(n.first)) {
                   minHeap.offer(Pair(n.first,n.second + time))
               }
            }             
        } 
        println("--visited size ${visited.size}")
        return if(visited.size == n) maxTime else -1
    }
}