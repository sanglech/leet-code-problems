package ArraysWithHashing.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
    886. Possible Bipartition
 */
public class PossibleBiPartition {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        if (n<=2) return true;
        int[] color = new int[n+1];
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        for (int i =0;i<=n;i++){
            adjList.put(i,new ArrayList<>());
        }

        for (int[] i :dislikes){
            int person = i[0];
            int dislikePerson = i[1];
            adjList.get(person).add(dislikePerson);
            adjList.get(dislikePerson).add(person);
        }

        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                color[i] = 1;
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    for (int j : adjList.get(cur)) {
                        if (color[j] == 0) {
                            color[j] = color[cur] == 1 ? 2 : 1;
                            q.offer(j);
                        } else {
                            if (color[j] == color[cur]) return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
