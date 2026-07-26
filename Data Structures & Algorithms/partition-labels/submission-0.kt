class Solution {
    fun partitionLabels(s: String): List<Int> {
        var lastIndex = HashMap<Char,Int>()
        var end = 0
        var size = 0
        var res = mutableListOf<Int>()

        s.forEachIndexed {
            i,c ->
            lastIndex[c] = i
        }

        for(i in s.indices) {
            end = max(end,lastIndex[s[i]]!!)
            size ++
            if(i==end) {
               res.add(size)
               size = 0
            }
        }
        return res
    }
}
