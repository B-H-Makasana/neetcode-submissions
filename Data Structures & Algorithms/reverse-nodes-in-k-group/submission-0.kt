/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
       var dummy = ListNode(0)
       dummy.next = head
       var gpPrev : ListNode?= dummy
       while(true) {
          val kth = getKth(gpPrev,k)
          if(kth == null) {
            break
          }
          var gpNext = kth.next
          var prev = gpNext
          var cur = gpPrev!!.next
          while(cur != gpNext) {
            val temp = cur!!.next
            cur.next = prev
            prev = cur
            cur = temp
          }
          val tmp = gpPrev.next
          gpPrev.next = kth
          gpPrev = tmp
        }
        return dummy.next
    }

fun getKth(cur: ListNode?,k:Int): ListNode? {
        var cur = cur
        var k = k
        while(cur!=null && k>0) {
            cur = cur.next
            k--
        }
        return cur
    }
}
