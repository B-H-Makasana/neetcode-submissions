class Solution {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
       var map = HashMap<Int,MutableSet<Pair<Int,Int>>>()
       for(i in 0 until n) {
         map[i] = mutableSetOf()
       }

       for(f in flights) {
        map[f[0]]!!.add(Pair(f[1],f[2]))
       }
       var res = Int.MAX_VALUE

       var q = PriorityQueue<Triple<Int,Int,Int>>(compareBy{it.second})
       q.offer(Triple(src,0,0))
       while(q.isNotEmpty()) {
          var p = q.poll()
          var d = p.first
          var cost = p.second
          var stop = p.third
          println("dst -> $d , cost -> $cost, stop -> $stop")
          if(dst == d) {
             return cost
          }

          if(stop > k) {
            continue
          }
          for(nei in map[d] ?: emptySet()) {
            q.offer(Triple(nei.first,nei.second + cost,stop+1))
          }
       }
       return if(res == Int.MAX_VALUE) -1 else res
    }
}
