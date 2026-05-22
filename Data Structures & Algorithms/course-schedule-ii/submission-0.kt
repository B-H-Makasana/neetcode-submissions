class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val map = HashMap<Int, MutableList<Int>>()  
        var visited = mutableSetOf<Int>()
        var res = mutableSetOf<Int>()

        for(i in 0 until numCourses) {
            map[i] = mutableListOf()
        }
        for(crs in prerequisites) {
            map[crs[0]]!!.add(crs[1])
        }

        fun dfs(p:Int) : Boolean {
            if(visited.contains(p)) {
                return false
            }
            if(map[p]!!.isEmpty()) {
                res.add(p)
                return true
            }
            visited.add(p)
            for(c in map[p]!!) {
                if(!dfs(c)) return false
            }
            res.add(p)
            visited.remove(p)
            map[p] = mutableListOf()
            return true
        }

        for(i in 0 until numCourses) {
            if(!dfs(i)) return intArrayOf()
        }
        return res.toIntArray()
    }
}
