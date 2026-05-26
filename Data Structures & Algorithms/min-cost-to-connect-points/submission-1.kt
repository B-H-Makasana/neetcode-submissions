class Solution {
    fun minCostConnectPoints(points: Array<IntArray>): Int {
      var heap = PriorityQueue<Pair<Int,Int>>(compareBy{it.first})
      val map = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
      var visited = mutableListOf<Int>()
      var path = 0
      var n = points.size
      for(i in 0 until n) {
        var x1 = points[i][0]
        var y1 = points[i][1]
        for(j in i+1 until n){
          var x2 = points[j][0]
          var y2 = points[j][1]
         val dist = abs(x1 - x2) + abs(y1 - y2)
         map.getOrPut(i){mutableListOf()}.add(Pair(dist,j))
         map.getOrPut(j){mutableListOf()}.add(Pair(dist,i))
        }
      }
      
      heap.add(Pair(0,0))

      while(visited.size < n) {
        var node = heap.poll()
        var x = node.second
        var cost = node.first
        if(visited.contains(x)) {
            continue
        }
        visited.add(x)
        path += cost
        for(p in map[x] ?: mutableListOf()) {
           heap.offer(p)
         }
      }
      return path
    }
}
