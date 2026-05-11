class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0 
        var r = nums.size - 1

        while(l<r) {
            val m = (l+r)/2
            if(nums[m] > nums[r]) {
                l = m+1
            } else {
                r = m
            }
        }

        val pivot = l
        l = 0
        r = nums.size - 1
        if(target >= nums[pivot] && target <= nums[r]) {
            l = pivot
        } else {
            r = pivot - 1
        }

        while(l<=r) {
            val mid = (l+r)/2
            if(nums[mid] == target) {
                return mid
            } else if(nums[mid]>target) {
                r = mid - 1
            } else {
                l = mid + 1
            }
        }
        return -1
    }
}
