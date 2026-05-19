class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
       var raw = grid.size
       var column = grid[0].size
       var direction = mutableListOf<Pair<Int,Int>>(Pair(0,1),Pair(1,0),Pair(0,-1),Pair(-1,0))
       var q = mutableListOf<Pair<Int,Int>>()
       var visited = mutableListOf<Pair<Int,Int>>()

       var fresh = 0
       var days = 0
       for(i in 0 until raw) {
        for(j in 0 until column) {
            if(grid[i][j] == 2) {
              q.add(Pair(i,j))  
            } else if(grid[i][j] == 1) {
                fresh ++
            }
        }
       }

         while(q.isNotEmpty() && fresh > 0) {
            repeat(q.size) {
               val first = q.removeFirst()
               for(dir in direction) {
                  val nr = first.first + dir.first
                  val nc = first.second + dir.second
                  if(nr<0 || nc< 0|| nr>=raw ||nc>=column||grid[nr][nc]!=1 || Pair(nr,nc) in visited) {
                    continue
                  }
                  grid[nr][nc] = 2
                  fresh --
                  q.add(Pair(nr,nc))
                  visited.add(Pair(nr,nc))
                }
            }
            days++
          }


       for(i in 0 until raw) {
        for(j in 0 until column) {
            if(grid[i][j] == 1) {
                return -1
            }
        }
       }

       return days
    }
}
