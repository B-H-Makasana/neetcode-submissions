class MedianFinder {

    var nums = mutableListOf<Int>()
    fun addNum(num: Int) {
        if(nums.isEmpty()) {
           nums.add(num)
        } else {
         nums.add(binarySearch(nums,num),num)
       }
    }
    fun binarySearch(nums:List<Int>,value:Int) : Int {
     var low = 0
     var high = nums.size 
     while(low < high) {
        var mid = (low + high)/2
        if(nums[mid] <= value) {
           low = mid  + 1
        } else {
            high = mid
        }
       }
       return low
    }

    fun findMedian(): Double {
        var n = nums.size
    return if (n % 2 == 1) {
        nums[n / 2].toDouble()
    } else {
        (nums[n / 2 - 1] + nums[n / 2]) / 2.0
    }
    }
}
