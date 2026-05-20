class Solution {
    fun solve(board: Array<CharArray>) {
        var raw = board.size
        var col = board[0].size
        
        fun dfs(r:Int,c:Int) {
            if(r<0 || c< 0 || r>=raw || c>=col || board[r][c]!='O') {
                return 
            }
            board[r][c] = '#'
            dfs(r+1,c)
            dfs(r-1,c)
            dfs(r,c+1)
            dfs(r,c-1)
        }

        for(c in 0 until col) {
             dfs(0,c)
             dfs(raw-1,c)
        }
        for(r in 0 until raw) {
            dfs(r,0)
            dfs(r,col-1)
        } 

        for(r in 0 until raw) {
            for(c in 0 until col) {
                if(board[r][c] == 'O') {
                    board[r][c] = 'X'
                }
            }
        }

        for(r in 0 until raw) {
            for(c in 0 until col) {
                if(board[r][c] == '#') {
                    board[r][c] = 'O'
                }
            }
        }
    }
}
