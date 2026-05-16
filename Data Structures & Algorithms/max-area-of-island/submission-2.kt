class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
       val raw = grid.size
       val col = grid[0].size
       val direction = mutableListOf(Pair(0,1),Pair(1,0),Pair(0,-1),Pair(-1,0))
       var max = 0
       fun bfs(i:Int,j:Int):Int {
          var area = 0
          val q = mutableListOf<Pair<Int,Int>>()
          q.add(Pair(i,j))
          
          while(q.isNotEmpty()) {
             val last = q.removeLast()
             for(dir in direction) {
                val nr = last.first + dir.first
                val nc = last.second + dir.second
                if(nr<0 || nr>=raw || nc<0 || nc>=col ||grid[nr][nc] == 0) {
                    continue
                }
                area ++
                q.add(Pair(nr,nc))
                grid[nr][nc] = 0
             }
          }
          return area
        }
        for(i in 0 until raw) {
            for(j in 0 until col) {
                if(grid[i][j] == 1) {
                    val area = bfs(i,j)
                    if(area == 0) {
                        max = max(max,1)
                    } else {
                       max = max(area,max)
                    }
                   grid[i][j] = 0
                }
            }
        } 
        return max
    }
}
