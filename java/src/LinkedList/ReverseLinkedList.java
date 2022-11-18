package LinkedList;
/*
    206. Reverse Linked List
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode currNode = head;
        ListNode prev= null;
        ListNode temp = null;

        while(currNode!=null){
            temp = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = temp;
        }
        return prev;
    }
}
