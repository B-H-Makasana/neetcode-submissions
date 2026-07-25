class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
       var total = 0
       var start = 0
       if(gas.sum() < cost.sum()) {
          return -1
       }
       for(i in 0 until gas.size) {
           var diff = gas[i] - cost[i]
           total += diff
           if(total < 0) {
             total = 0
             start = i + 1
           }
       }

       return start
    }
}
