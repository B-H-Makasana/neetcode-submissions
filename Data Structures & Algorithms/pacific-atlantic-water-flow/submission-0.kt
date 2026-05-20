class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
       var raw = heights.size
       var col = heights[0].size
       var pac = Array(raw) {
          BooleanArray(col)
       }
       var atl = Array(raw) {
          BooleanArray(col)
       }

       fun dfs(r:Int,c:Int,visited:Array<BooleanArray>,prev:Int) {
          if(r<0 || r>=raw || c<0 || c>=col || visited[r][c] || heights[r][c]<prev) {
            return
          }
          visited[r][c] = true
          dfs(r+1,c,visited,heights[r][c])
          dfs(r-1,c,visited,heights[r][c])
          dfs(r,c+1,visited,heights[r][c])
          dfs(r,c-1,visited,heights[r][c])
        }

        for(c in 0 until col) {
            dfs(0,c,pac,heights[0][c])
            dfs(raw-1,c,atl,heights[raw-1][c])
        }

        for(r in 0 until raw) {
            dfs(r,0,pac,heights[r][0])
            dfs(r,col-1,atl,heights[r][col-1])
        }

        var res = mutableListOf<List<Int>>()
        for(r in 0 until raw) {
            for(c in 0 until col) {
                if(atl[r][c] && pac[r][c]) {
                   res.add(listOf(r,c))
                }
            }
        }
        return res
    }
}
