class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        var map = HashMap<Int,MutableList<Int>>()
        var visited = mutableSetOf<Int>()
        var res = 0

        for(i in 0 until n) {
           map[i] = mutableListOf()
        } 

        for(e in edges) {
           map[e[0]]!!.add(e[1])
           map[e[1]]!!.add(e[0])
        }
        
        fun dfs(node:Int) {
            for(n in map[node]!!) {
               if(!visited.contains(n)) {
                 visited.add(n) 
                 dfs(n)
               }
            }
        }

        for(i in 0 until n) {
           if(!visited.contains(i)) {
              visited.add(i)
              dfs(i)
              res ++
            }
        }
        return res
    }
}
