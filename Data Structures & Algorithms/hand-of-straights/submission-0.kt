class Solution {
    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
         var heap = PriorityQueue<Int>()
         var m = HashMap<Int,Int>()
         hand.sort()
         for(i in hand) {
            m[i] = m.getOrDefault(i, 0) + 1
         }

         for(num in hand) {
            if(m.getOrDefault(num,0) > 0) {
            for(i in num until num+groupSize) {
                if(m.getOrDefault(i,0) == 0) {
                    return false
                }
                m[i] = m[i]!! - 1
            }
            }
         }
         return true
    }
}
