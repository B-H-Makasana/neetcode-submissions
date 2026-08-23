class Solution {
    fun setZeroes(matrix: Array<IntArray>) {
        var r = matrix.size
        var c = matrix[0].size

        var rawZero =  false

        for(i in 0 until r) {
           for(j in 0 until c) {
              if(matrix[i][j] == 0) {
                 matrix[0][j] = 0
                 if(i > 0) {
                    matrix[i][0] = 0
                 } else {
                    rawZero = true
                 }
              }
           }
        }

        for(i in 1 until r) {
           for(j in 1 until c) {
              if(matrix[0][j] == 0 || matrix[i][0] == 0) {
                 matrix[i][j] = 0
              }
           }
        }

        if(matrix[0][0] == 0) {
            for (i in 0 until r) {
                matrix[i][0] = 0
            }
        }

        if (rawZero) {
            for (j in 0 until c) {
                matrix[0][j] = 0
            }
        }
    }
}
