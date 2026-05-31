class Solution {
    fun foreignDictionary(words: Array<String>): String {
      var map = HashMap<Char,MutableSet<Char>>()
      var visited = HashMap<Char,Boolean>()
      var res = mutableListOf<Char>()
      for(w in words) {
        for(c in w) {
           map.putIfAbsent(c, mutableSetOf())     
        }
      }
      for(i in 0 until words.size - 1) {
         var w1 = words[i]
         var w2 = words[i+1]
         var minLength = minOf(w1.length,w2.length)
         if(w1.length > minLength && w1.substring(0,minLength) == w2.substring(0,minLength)) {
            return ""
         }
         for(j in 0 until minLength) {
            if(w1[j]!=w2[j]) {
                map[w1[j]]!!.add(w2[j])
                break
            }
         }
        }

       fun dfs(c:Char) : Boolean {
          if(c in visited) {
             return visited[c]!!
          }
          visited[c] = true
          for(n in map[c]?:emptySet()) {
             if(dfs(n)) {
                return true
             }
          }
          visited[c] = false
          res.add(c)
          return false
       }

       for(key in map.keys) {
          if(dfs(key)) {
            return ""
          }
       }

       return res.reversed().joinToString("")
    }
}