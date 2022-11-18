package Heap;

import java.util.PriorityQueue;

public class LastStoneWeight {
    public static int LastStoneWeight (int[] stones){
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
        int res = 0;
        // Multiply all values by -1 to create a Max Heap
        for (int stone : stones) pQueue.add(-stone);

        while (pQueue.size() > 1) {
            int stone1 = pQueue.remove();
            int stone2 = pQueue.remove();
            if (stone1 != stone2) pQueue.add(stone1 - stone2);
        }
        if(pQueue.size()==1){
            res = pQueue.poll();
        }

        return res;
    }
}
