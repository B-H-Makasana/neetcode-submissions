class TimeMap() {

    var list: MutableList<Triple<String, String, Int>> = mutableListOf()

    fun set(key: String, value: String, timestamp: Int) {
        list.add(Triple(key,value,timestamp))
    }

    fun get(key: String, timestamp: Int): String {
        var last = list.size - 1
        while(last>=0) {
            if(list[last].first == key && list[last].third <=timestamp) {
                return list[last].second
            }
            last --
        }
        return ""
    }
}