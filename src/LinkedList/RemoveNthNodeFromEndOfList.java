package LinkedList;
/*
    19. Remove Nth Node From End of List
 */

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0,head);

        ListNode left = temp;
        ListNode right =head;
        int i=0;
        while(i<n){
            i++;
            right= right.next;
        }

        while(right!=null){
            left=left.next;
            right = right.next;
        }

        left.next= left.next.next;
        return temp.next;
    }
}
