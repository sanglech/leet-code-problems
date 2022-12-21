package Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    841. Keys and Rooms
 */
public class KeysAndRooms {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        if(n <=1) return true;

        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visit = new HashSet<>();

        q.add(0);
        visit.add(0);

        while(!q.isEmpty()){
            for(int i=0;i<q.size();i++){
                int currentRoom = q.poll();
                for(Integer key: rooms.get(currentRoom)){
                    if(!visit.contains(key)){
                        visit.add(key);
                        q.add(key);
                    }
                }
            }
        }

        return visit.size()==n;
    }
}
