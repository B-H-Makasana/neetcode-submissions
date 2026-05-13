class Solution {
    fun solveNQueens(n: Int): List<List<String>> {
       var res = mutableListOf<List<String>>()
       var col = HashSet<Int>()
       var posDia = HashSet<Int>()
       var negDia = HashSet<Int>()
       var board = Array(n) {CharArray(n){'.'}}
 
       fun backTrack(r:Int) {
          if(r >=n) {
            res.add(board.map{it.joinToString("")})
            return 
          }
          for(c in 0 until n) {
            if(c in col || (r+c) in posDia || (r-c) in negDia) {
                continue
            }
            col.add(c)
            posDia.add(r+c)
            negDia.add(r-c)
            board[r][c] = 'Q'
            backTrack(r+1)
            col.remove(c)
            posDia.remove(r+c)
            negDia.remove(r-c)
            board[r][c] = '.'
          } 
        }
       backTrack(0)
       return res
    }
}
