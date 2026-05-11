class MedianFinder {

    var nums = mutableListOf<Int>()
    fun addNum(num: Int) {
        println("Add num $num")
        if(nums.isEmpty()) {
           println("----- First if----")
           nums.add(num)
        } else {
         println("----- Fourth if----")
         nums.add(binarySearch(nums,num),num)
       }
       nums.forEach {
        println("Nums $it")
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
       println("Binary serach res $low")
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
