package Graphs;

import java.util.*;

/*
    1971. Find if Path Exists in Graph
 */
public class FindIfPathExists {
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        if (n==0) return false;
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        HashSet <Integer> visit = new HashSet<>();
        for (int i=0;i<n;i++){
            adjList.put(i,new ArrayList<>());
        }

        for(int[] edge: edges){
            int src = edge[0];
            int dest = edge[1];

            if(Math.min(src,dest)<0 || src >= n || dest >=n){
                return false;
            }
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }

        q.add(source);
        visit.add(source);

        while(!q.isEmpty()){
            for (int i =0;i<q.size();i++){
                int currentValue = q.poll();
                for(Integer dest:adjList.get(currentValue)){
                    if(dest==destination){
                        return true;
                    }
                    if(!visit.contains(dest)){
                        visit.add(dest);
                        q.add(dest);
                    }
                }
            }
        }
        return false;
    }
}
