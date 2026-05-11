class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        var dis = mutableListOf<Pair<Int,Int>>()
        points.forEachIndexed { index,value ->
            var x = value[0]
            var y = value[1]
            var diff = (x * x) + (y * y)
            dis.add(Pair(index,diff))
        }

        var pq = PriorityQueue<Pair<Int,Int>>(compareByDescending { it.second } )

        dis.forEach {
            pq.add(it)
            while(pq.size > k) {
              pq.poll()
            }
        }

        var res = mutableListOf<IntArray>()
        while(pq.isNotEmpty()) {
           res.add(points[pq.poll().first])
        }
        return res.toTypedArray()
    }
}
