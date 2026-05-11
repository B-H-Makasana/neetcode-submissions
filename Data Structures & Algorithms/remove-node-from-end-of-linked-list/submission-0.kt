/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var nodes = mutableListOf<ListNode>()
        var cur = head
        while(cur!=null) {
            nodes.add(cur)
            cur = cur.next
        }
        var index = nodes.size - n
        if(index == 0) {
            return head?.next
        }
        var prev = nodes[index-1]
        var next = if(n != 1) nodes[index+1] else null
        nodes.removeAt(index)
        prev.next = next
        return head
    }
}
