class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        var map = HashMap<Int,MutableList<Int>>()
        var n = edges.size
        for(i in 1 until n+1) {
            map[i] = mutableListOf()
        }


        fun dfs(node:Int,parent:Int,visited:BooleanArray) : Boolean {
            if(visited[node]) {
                return true
            }
            visited[node] = true
            for(n in map[node]!!) {
                if(n == parent) continue
                if(dfs(n,node,visited)) return true
            }
            return false
        }

        for(edge in edges) {
            map[edge[0]]!!.add(edge[1])
            map[edge[1]]!!.add(edge[0])
            val visit = BooleanArray(n + 1)
            if(dfs(edge[0],-1,visit)) {
               return intArrayOf(edge[0],edge[1])
            }
        } 
        return intArrayOf()
    }
}