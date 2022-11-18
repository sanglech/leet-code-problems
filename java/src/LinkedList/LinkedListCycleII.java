package LinkedList;

import java.util.HashSet;
/*
    142. Linked List Cycle II
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode curr = head;
        HashSet<ListNode> visited = new HashSet<ListNode>();
        while(curr!=null){
            if(!visited.contains(curr)){
                visited.add(curr);
                curr = curr.next;
            }
            else {
                return curr;
            }
        }
        return null;
    }
}
