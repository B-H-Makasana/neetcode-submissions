class Solution {
    fun reverseBits(n: Int): Int {
        var res = 0
        for(i in 0 until 32) {
            var bit = (n shr i) and 1
            res = res or (bit shl (31-i))
        }
        return res
    }
}
