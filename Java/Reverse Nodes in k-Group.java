/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class Solution {
    /*
     * @param head: a ListNode
     * @param k: An integer
     * @return: a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (true) {
            head = reverseK(head, k);
            if (head == null) {
                break;
            }
        }
        return dummy.next;
    }
    
    public ListNode reverseK(ListNode head, int k) {
        ListNode nk = head;
        for (int i = 0; i < k; i++) {
            if (nk == null) return null;
            nk = nk.next;
        }
        if (nk == null) return null;
        ListNode nkPlus = nk.next;
        ListNode n1 = head.next;
        ListNode prev = null;
        ListNode curr = n1;
        while (curr != nkPlus) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        head.next = nk;
        n1.next = nkPlus;
        return n1;
    }
}