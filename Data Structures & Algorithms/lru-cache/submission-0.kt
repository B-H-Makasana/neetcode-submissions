class LRUCache(capacity: Int) {
    var map = mutableMapOf<Int,Int>()
    var c = capacity
    fun get(key: Int): Int {
        val res = map.getOrDefault(key,-1)
        if(res!=-1) {
            map.remove(key)
            map[key] = res
        }
        return res
    }

    fun put(key: Int, value: Int) {
      if (map.containsKey(key)) {
            map.remove(key)
            map[key] = value
            return
        }

        if (map.size >= c) {
            val lruKey = map.entries.first().key
            map.remove(lruKey)
        }

        map[key] = value
    }
}