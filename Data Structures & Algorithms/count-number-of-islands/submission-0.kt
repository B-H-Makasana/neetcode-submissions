class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
      var direction = mutableListOf(intArrayOf(0,-1),intArrayOf(-1,0),intArrayOf(1,0),intArrayOf(0,1))
      var noRaw = grid.size
      var nCol = grid[0].size
      var numOfIsland = 0
      fun bfs(r:Int,c:Int) {
           var q = mutableListOf<Pair<Int,Int>>()
           grid[r][c] = '0'
           q.add(Pair(r,c))
           while(q.isNotEmpty()) {
              var last = q.removeLast()
              for(dir in direction) {
                  var nr = last.first+dir[0]
                  var nc = last.second+dir[1]
                  if(nr < 0 || nc<0 || nr>= noRaw || nc>=nCol || grid[nr][nc] == '0') {
                     continue
                   }
                    q.add(Pair(nr,nc))
                    grid[nr][nc] = '0'
                }
           }
        }
        for(i in 0 until noRaw) {
            for(j in 0 until nCol) {
                if(grid[i][j] == '1') {
                    bfs(i,j)
                    numOfIsland ++
                    grid[i][j] = '0'
                }
            }
        }
        return numOfIsland
    }
}