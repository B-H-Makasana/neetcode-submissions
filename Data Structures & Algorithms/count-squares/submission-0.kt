class CountSquares {
    var hashMap = HashMap<Pair<Int,Int>,Int>()
    var list = mutableListOf<IntArray>() 

    fun add(point: IntArray) {
        var p = Pair(point[0],point[1])
        hashMap[p] = hashMap.getOrDefault(p,0) + 1
        list.add(point)
    }

    fun count(point: IntArray): Int {
         var result = 0
         for(p in list) {
            if(Math.abs(p[0] - point[0]) != Math.abs(p[1] - point[1]) || p[1] == point[1] || p[0] == point[0]) {
                continue
            }
            result += (hashMap[Pair(p[0],point[1])] ?: 0) * (hashMap[Pair(point[0],p[1])] ?: 0)
         }
         return result
    }
}
