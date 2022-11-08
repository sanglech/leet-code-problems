package LinkedList;

/*
    2130. Maximum Twin Sum of a Linked List
 */
public class MaximumTwinSum {
    public int pairSum(ListNode head) {
        ListNode prev = null, fast = head, slow = head, next=null, newCur=head;

        int res = 0;
        while(fast!=null &&fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        //reverse second half of list
        while(slow != null) {
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        //prev is now starting point of reversed list
        while(true) {
            res = Math.max(res, prev.val + newCur.val);
            if(newCur.next== prev) break;
            newCur = newCur.next;
            prev = prev.next;
        }

        return res;
    }
}
