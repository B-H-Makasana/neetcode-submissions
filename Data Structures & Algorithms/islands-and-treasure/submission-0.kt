class Solution {
    fun islandsAndTreasure(grid: Array<IntArray>) {
       var raw = grid.size
       var column = grid[0].size
       var direction = mutableListOf<Pair<Int,Int>>(Pair(0,1),Pair(0,-1),Pair(1,0),Pair(-1,0))
       fun bfs(i:Int,j:Int) {
          var q = mutableListOf<Pair<Int,Int>>()
          val visited = mutableSetOf<Pair<Int, Int>>()
          var cnt = 0
          q.add(Pair(i,j))
          visited.add(Pair(i,j))
          while(q.isNotEmpty()) {
            repeat(q.size) {
             val last = q.removeFirst()
             var nr = last.first
             var nc = last.second
             if(grid[nr][nc] == 0) {
                grid[i][j] = cnt
                return 
             }
          for(dir in direction) {
              nr = last.first + dir.first
              nc = last.second + dir.second
             if(nr<0 || nc<0 ||nr>=raw || nc>=column || grid[nr][nc]==-1 || Pair(nr,nc) in visited) {
                 continue
             }
                visited.add(Pair(nr,nc))
                q.add(Pair(nr,nc))
           }
            }
            cnt ++
          }
       }
    

       for(i in 0 until raw) {
          for(j in 0 until column) {
             if(grid[i][j]==Int.MAX_VALUE) {
                bfs(i,j)
             }
          }
       }
    }
}
