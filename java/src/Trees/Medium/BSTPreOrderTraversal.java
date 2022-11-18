package Trees.Medium;

import Trees.PreOrderNode;

import java.util.ArrayList;
import java.util.List;

public class BSTPreOrderTraversal {
    public List<Integer> preorder(PreOrderNode root) {
        List <Integer> output = new ArrayList<Integer>();
        dfs(root,output);

        return output;
    }

    public void dfs(PreOrderNode curr, List<Integer> out){
        if(curr==null) return;
        else {
            out.add(curr.val);
            for(PreOrderNode c: curr.children){
                dfs(c,out);
            }
        }
    }
}
