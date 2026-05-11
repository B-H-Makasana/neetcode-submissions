class TrieNode {
    val children = arrayOfNulls<TrieNode>(26)
    var endOfWord = false

}
class PrefixTree {
    var root = TrieNode()

    fun insert(word: String) {
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
        var cur = root
        for(c in word) {
            if(cur.children[c-'a'] == null) {
                return false
            }
            cur = cur.children[c-'a']!!
        }
        return cur.endOfWord
    }

    fun startsWith(prefix: String): Boolean {
        var cur = root
        for(c in prefix) {
            if(cur.children[c-'a'] == null) {
                return false
            }
            cur = cur.children[c-'a']!!
        }
        return true
    }
}
