/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var node = dummy
        var h1 = l1
        var h2 = l2
        var carry = 0
        while(h1!=null || h2!=null || carry != 0) {
            val v1 = h1?.`val` ?: 0
            val v2 = h2?.`val` ?: 0
            var res = v1 + v2 + carry
            carry = res / 10
            res = res % 10     
            node.next = ListNode(res)      
            h1 = h1?.next
            h2 = h2?.next
            node = node.next!!
        }
        return dummy.next
    }
}
