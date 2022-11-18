package LinkedList;

/*
    876. Middle of the Linked List
 */
public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode curr = head;
        if(head==null){
            return null;
        }
        int count = 0;
        while(curr!=null){
            curr=curr.next;
            count++;
        }
        curr = head;
        for(int i=0;i< Math.ceil(count/2);i++){
            curr = curr.next;
        }

        return curr;

    }
}
