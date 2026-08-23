class Solution {
    fun rotate(matrix: Array<IntArray>) {
      var l = 0
      var r = matrix.size - 1

      while(l<r) {
         for(i in 0 until (r-l)) {
            var t = l
            var b = r

            var topLeft = matrix[t][l+i]

            matrix[t][l+i] = matrix[b-i][l]

            matrix[b-i][l] = matrix[b][r-i]
           
            matrix[b][r-i] = matrix[t+i][r]
            
            matrix[t+i][r] = topLeft
          }
          l++
          r--
      }

    }
}
