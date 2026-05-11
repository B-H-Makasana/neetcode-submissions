class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
       var raw = Array(9) {HashSet<Char>()}
       var column = Array(9) {HashSet<Char>()}
       var square = Array(9) {HashSet<Char>()}

       for(r in 0 until 9) {
         for(c in 0 until 9) {
            if(board[r][c] == '.') {
                continue
            } else {
                var current = board[r][c]
                var sIndex = ((r/3) * 3 + (c/3))
                if( current in raw[r] || current in column[c] || current in square[sIndex]) {
                    return false
                }
                raw[r].add(current)
                column[c].add(current)
                square[sIndex].add(current) 
            }
         }
       }
       return true

    }
}
