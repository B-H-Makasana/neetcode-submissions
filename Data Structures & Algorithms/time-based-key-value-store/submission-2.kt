class TimeMap() {

    var map = HashMap<String,MutableList<Pair<String,Int>>>()

    fun set(key: String, value: String, timestamp: Int) {
        if(!map.containsKey(key)) {
            map[key] = mutableListOf()
        } 
        map[key]!!.add(Pair(value,timestamp))
    }

    fun get(key: String, timestamp: Int): String {
        if(!map.containsKey(key)) {
           return ""
        }
        var list = map[key]!!

        var l = 0
        var h = list.size - 1
        var res = ""
        while(l<=h) {
            val mid = (l+h)/2
            if(list[mid].second <= timestamp) {
                res = list[mid].first
                l = mid + 1
            } else {
                h = mid - 1
            }
        }
        return res
    }
}