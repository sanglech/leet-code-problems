package Trees;

import java.util.List;

// Definition for a Node.
public class PreOrderNode {
    public int val;
    public List<PreOrderNode> children;

    public void PreOrderNode() {
    }

    public void PreOrderNode(int _val) {
        val = _val;
    }

    public void PreOrderNode(int _val, List<PreOrderNode> _children) {
        val = _val;
        children = _children;
    }
}
