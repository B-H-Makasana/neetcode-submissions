class Solution {
    fun swimInWater(grid: Array<IntArray>): Int {
        var visited = mutableSetOf<Pair<Int,Int>>()
        var q = PriorityQueue<Pair<Int,Pair<Int,Int>>>(compareBy {it.first})
        val direction = mutableListOf<Pair<Int,Int>>(Pair(-1,0),Pair(0,-1),Pair(1,0),Pair(0,1))
        q.offer(Pair(grid[0][0],Pair(0,0)))
        visited.add(Pair(0,0))

        while(q.isNotEmpty()) {
            val pair = q.poll()
            val cost:Int =  pair.first
            val r = pair.second.first
            val c = pair.second.second

            if(r >= grid[0].size-1 && c >= grid.size-1) {
                return cost
            }

            for(dir in direction) {
                val nr = r + dir.first
                val nc = c + dir.second

                if(nr<0 || nc<0 || nr >= grid[0].size || nc >= grid.size || Pair(nr,nc) in visited){
                    continue
                }
                visited.add(Pair(nr,nc))
                q.offer(Pair(max(grid[nr][nc],cost),Pair(nr,nc)))
            }
        }
        return -1
    }
}
