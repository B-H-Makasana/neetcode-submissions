class Solution {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val sorted = tickets.sortedWith(
         compareBy<List<String>> { it[0] }
        .thenBy { it[1] } )
        var map = mutableMapOf<String,MutableList<String>>()
        for(list in sorted) {
           if(map[list[0]] == null) {
             map[list[0]] = mutableListOf()
           }
            map[list[0]]!!.add(list[1])
        }

        var res = mutableListOf<String>() 
        res.add("JFK")
        fun dfs(v:String) : Boolean {
            if(res.size == tickets.size +1 ) {
                return true
            }

            if(map[v] == null) {
                return false
            }

            var temp = map[v]!!
            for(i in temp.indices) {
                val v = temp.removeAt(i)
                res.add(v)
                if(dfs(v)) return true

                temp.add(i,v) 
                res.removeLast()
            }
            return false
        }

        dfs("JFK")
        return res
    }
}