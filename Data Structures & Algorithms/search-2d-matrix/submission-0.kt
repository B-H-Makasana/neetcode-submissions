class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
      var findArray: IntArray? = null
        for(i in 0..matrix.size-1) {
            val lastIndex = matrix[i].size - 1
            if(matrix[i][lastIndex] >= target) {
                findArray = matrix[i]
                break
            }
        }
        if(findArray == null) {
            return false
        }
        var low = 0
        var high = findArray.size - 1
        while(low<=high) {
            val mid = low + (high-low)/2
            if(findArray[mid] == target) {
                print("mid is $mid")
                return true
            } else if(findArray[mid] < target) {
                 low = mid + 1
            } else {
                 high = mid - 1
            }
        }
        return false
    }
}
