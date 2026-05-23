class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
      var map = HashMap<Int,MutableList<Int>>()
      var visited = mutableSetOf<Int>()
      for(i in 0 until n) {
         map[i] = mutableListOf()
      }
      for(node in edges) {
         map[node[0]]!!.add(node[1])
         map[node[1]]!!.add(node[0])
      }

      fun dfs(node:Int,parent:Int) : Boolean {
        println(visited.joinToString())     
        println("----dfs---$node parent $parent")
         if(visited.contains(node)) {
            println("----visited---$node")
            return false
         }
         visited.add(node)
         for(child in map[node]!!) {
            if(child == parent) continue
            if(!dfs(child,node)) return false
         }
         return true
      }
         
      return  dfs(0,-1) && visited.size == n
    }
}
