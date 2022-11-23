from typing import Optional
from ListNode import ListNode

def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        newHead = ListNode()
        cur = newHead
        while list1 and list2:
            if(list1.val < list2.val):
                cur.next = list1
                list1=list1.next
            else:
                cur.next = list2
                list2 = list2.next
            cur = cur.next
        if list1:
            cur.next=list1
        elif list2:
            cur.next=list2
        return newHead.next
