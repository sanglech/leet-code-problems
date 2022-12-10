package Graphs;


import java.util.ArrayList;
import java.util.HashMap;

/*
    133. Clone Graph
 */
public class CloneGraph {
    public HashMap<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node==null) return null;
        if (map.containsKey(node.val)) return map.get(node.val);
        Node copy = new Node(node.val,new ArrayList<Node>());
        map.put(node.val,copy);
        for(Node n: node.neighbors){
            copy.neighbors.add(cloneGraph(n));
        }
        return copy;
    }
}
