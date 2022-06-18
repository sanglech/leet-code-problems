package LinkedList;

public class LinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    // Time Complexity: O(n)
    // Space: O(1)
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

    // Time Complexity: O(n+m)
    // Space: O(1)
    // trick: Create a dummy node as head and create a current node in beginning
    // then return the dumy nodes next.
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode currNode = new ListNode();
        ListNode head =currNode;

        while(list1!=null && list2!=null){
            if(list1.val < list2.val){
                currNode.next = list1;
                list1=list1.next;
            }
            else {
                currNode.next = list2;
                list2 = list2.next;
            }
            currNode = currNode.next;
        }

        if(list1!=null){
            currNode.next = list1;
        }
        else if(list2!=null){
            currNode.next = list2;
        }
        return head.next;
    }

    // Time Complexity: O(n)
    // Space: O(1)
    public void reorderList(ListNode head) {
        if(head==null||head.next==null) return;

        //Find the middle of the list
        ListNode p1=head;
        ListNode p2=head;
        while(p2.next!=null&&p2.next.next!=null){
            p1=p1.next;
            p2=p2.next.next;
        }

        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode preMiddle=p1;
        ListNode preCurrent=p1.next;
        while(preCurrent.next!=null){
            ListNode current=preCurrent.next;
            preCurrent.next=current.next;
            current.next=preMiddle.next;
            preMiddle.next=current;
        }

        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        p1=head;
        p2=preMiddle.next;
        while(p1!=preMiddle){
            preMiddle.next=p2.next;
            p2.next=p1.next;
            p1.next=p2;
            p1=p2.next;
            p2=preMiddle.next;
        }
    }
}
