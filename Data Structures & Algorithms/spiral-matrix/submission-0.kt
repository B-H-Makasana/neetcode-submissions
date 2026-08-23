class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
         var res = mutableListOf<Int>()
         var l = 0
         var t = 0
         var r = matrix[0].size
         var b = matrix.size

         while(l<r && t < b) {
            for(i in l until r) {
                res.add(matrix[l][i])
            }
            t++
            for(i in t until b) {
                res.add(matrix[i][r-1])
            }
            r--

             if (!(l < r && t < b)) break

            for(i in r - 1 downTo l) {
                res.add(matrix[b-1][i])
            }
            b--
            for(i in b - 1 downTo t) {
                res.add(matrix[i][l])
            }
            l++
         }
         return res
    }
}
