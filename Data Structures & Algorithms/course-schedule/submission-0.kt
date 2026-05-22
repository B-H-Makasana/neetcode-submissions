class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        var preMap = mutableMapOf<Int,MutableList<Int>>()
        var visited = mutableSetOf<Int>()

        for (i in 0 until numCourses) {
            preMap[i] = mutableListOf()
        }
        for(pre in prerequisites) {
            preMap[pre[0]]!!.add(pre[1])
        }
        
        fun dfs(pre:Int) : Boolean {
              if(visited.contains(pre)) {
                 return false
              }
              if(preMap[pre]?.isEmpty() == true ) {
                  return true
              }
              visited.add(pre)
              for(crs in preMap[pre]?: mutableListOf()){
                 if(!dfs(crs)) {
                    return false
                 }
              }
              visited.remove(pre)
              preMap[pre] = mutableListOf()
           
           return true
        }
        for(c in 0 until numCourses) {
            if(!dfs(c)) return false
        }
        return true
    }
}
