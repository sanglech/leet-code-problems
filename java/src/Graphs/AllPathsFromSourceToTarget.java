package Graphs;

import java.util.*;

/*
    797. All Paths From Source to Target
 */
public class AllPathsFromSourceToTarget {
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        HashMap<Integer,List<Integer>> adjList = new HashMap<>();
        List<List<Integer>>res = new ArrayList<>();

        for (int i =0; i < n;i++){
            for (int j=0;j<graph[i].length;j++){
                adjList.computeIfAbsent(i,k -> new ArrayList<>()).add(graph[i][j]);
            }
        }

        dfs(0,n-1,adjList, new HashSet<>(),new ArrayList<>(),res);

        return res;
    }

    public static void dfs(Integer node, Integer target, HashMap<Integer, List<Integer>> adjList,
                           HashSet<Integer> visit, List<Integer> cur, List<List<Integer>> res){
        if (visit.contains(node)){
            return;
        }
        if(Objects.equals(node, target)){
            // Need to include target node to the result
            cur.add(node);
            res.add(new ArrayList<>(cur));
            // Need to remove target from current in case of more paths
            cur.remove(node);
            return;
        }
        visit.add(node);
        cur.add(node);
        List<Integer> neighbours = adjList.get(node);

        if(neighbours!=null){
            for (Integer n : neighbours){
                dfs(n,target,adjList,visit,cur,res);
            }
        }

        visit.remove(node);
        cur.remove(node);
    }
}
