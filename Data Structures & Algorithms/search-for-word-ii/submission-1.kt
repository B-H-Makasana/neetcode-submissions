class Solution {

    class TrieNode() {
        var children = HashMap<Char,TrieNode>()
        var endOfWord = false
    
    fun addWord(word:String) {
        var root = this
        for(c in word) {
            root = root.children.getOrPut(c) {
                TrieNode()
            }
        }
        root.endOfWord = true
    }
    }

    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        var res = mutableSetOf<String>()
       var rawSize = board.size
       var colSize = board[0].size 
       var path = mutableSetOf<Pair<Int,Int>>()
       var trie = TrieNode()
       for(word in words) {
          trie.addWord(word)
       }
    

    fun dfs(r:Int,c:Int,node:TrieNode,word:String) {
    
        if(r<0 || c<0 || r>=rawSize || c>= colSize || Pair(r,c) in path || board[r][c] !in node.children) {
            return
        }
        path.add(Pair(r,c))
        var newNode = node.children[board[r][c]]!!
        val newWord = word+board[r][c]
        if(newNode.endOfWord) {
            res.add(newWord)
        }
        dfs(r+1,c,newNode,newWord) 
        dfs(r-1,c,newNode,newWord)
        dfs(r,c+1,newNode,newWord)
        dfs(r,c-1,newNode,newWord)
        path.remove(Pair(r,c))
    }

     for(r in 0 until rawSize) {
        for(c in 0 until colSize) {
            dfs(r,c,trie,"")
        }
      }
     return res.toList()
    }
}
