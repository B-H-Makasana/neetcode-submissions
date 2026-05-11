class TrieNode() {
    var children = arrayOfNulls<TrieNode>(26)
    var endOfWord = false
}

class WordDictionary {
    var root = TrieNode()

    fun addWord(word: String) {
        var cur = root
        for(c in word) {
            var i = c - 'a'
            if(cur.children[i] == null) {
                cur.children[i] = TrieNode()
            }
            cur = cur.children[i]!!
        }
        cur.endOfWord = true
    }

    fun search(word: String): Boolean {
       return dfs(word,0,root)
    }
    
    fun dfs(word:String,j:Int,node:TrieNode) : Boolean{
        var cur = node
        for(i in j until word.length) {
            var c = word[i]
            if(c == '.') {
                for(child in cur.children) {
                    if(child!=null && dfs(word,i+1,child)) {
                        return true
                    }
                }
                return false
            } else {
                if(cur.children[c - 'a'] == null) {
                    return false
                }
                cur = cur.children[c - 'a']!!
            }
        }
        return cur.endOfWord
    }
}
