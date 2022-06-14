package LinkedList;

import java.util.HashSet;

public class hasCycleSolution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        HashSet<ListNode> vals = new HashSet<>();
        return dfs(head, vals);
    }

    public boolean dfs(ListNode curr, HashSet<ListNode> visited) {
        if (curr == null) return false;
        if (visited.contains(curr)) return true;

        visited.add(curr);

        return dfs(curr.next, visited);
    }
}
