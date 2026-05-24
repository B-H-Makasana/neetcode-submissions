class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: MutableList<String>): Int {
       if(endWord !in wordList) {
         return 0
       }
       var map = mutableMapOf<String,MutableList<String>>()
       wordList.add(beginWord)
       var res = 0
       for(word in wordList) {
          for(j in 0 until word.length) {
              var pattern = word.substring(0, j) + "*" + word.substring(j+1, word.length)
              if(map[pattern] == null) {
                map[pattern] = mutableListOf()
              }
              map[pattern]!!.add(word)
          }
       }

       var q = mutableListOf<String>()
       var visited = mutableSetOf<String>()
       q.add(beginWord)
       visited.add(beginWord)
       while(q.isNotEmpty()) {
        res++
         for(i in 0 until q.size) {
            val first = q.removeFirst()
            if(first == endWord) {
                return res
            }
             for(j in 0 until first.length) {
              var pattern = first.substring(0, j) + "*" + first.substring(j+1, first.length)
                 for(w in map[pattern]!!) {
                    if(!visited.contains(w)) {
                        visited.add(w)
                        q.add(w)
                    }
                 }
              }
            }  
         }
         return 0
       }
    }

