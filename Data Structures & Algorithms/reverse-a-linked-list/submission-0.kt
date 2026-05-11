/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var prev:ListNode? = null
        var cur = head
        while(cur!=null) {
            var temp = cur.next
            cur.next = prev
            prev = cur
            cur = temp
        }
        return prev             
    }
}