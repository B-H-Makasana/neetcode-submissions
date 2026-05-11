/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var dummy:ListNode = ListNode(0)
        var head:ListNode? = dummy
        var head1 = list1
        var head2 = list2
        while(head1 != null && head2 != null) {
           if(head1.`val` < head2.`val`) {
                head!!.next = head1
                head1 = head1.next
            } else {
                head!!.next = head2
                head2 = head2.next
            }     
            head = head.next
        }
        while(head1!=null) {
            head!!.next = head1
            head = head.next
            head1 = head1.next
        }
         while(head2!=null) {
            head!!.next = head2
            head = head.next
            head2 = head2.next
        }
        return dummy.next
    }
}
