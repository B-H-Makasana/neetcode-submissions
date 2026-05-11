class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
       var nRaw = board.size
       var nColumn = board[0].size
       var path = mutableSetOf<Pair<Int,Int>>()

       fun dfs(r:Int,c:Int,i:Int) : Boolean{
          if(i == word.length) {
            return true
          }
          if(r<0 || c<0 || r>=nRaw || c>=nColumn || Pair(r,c) in path
            || board[r][c] != word[i]
          ) {
            return false
          } 
          path.add(Pair(r,c))
          var res =   dfs(r+1,c,i+1) ||
                      dfs(r-1,c,i+1) ||
                      dfs(r,c-1,i+1) ||
                      dfs(r,c+1,i+1)
          path.remove(Pair(r,c))            
          return res          
       } 
       for(r in 0 until nRaw) {
         for(c in 0 until nColumn) {
            if(dfs(r,c,0)) {
                return true
            }
         }
        }
        return false
    }
}
