package ArraysWithHashing.Medium;

import java.util.*;
/*
    347. Top K Frequent Elements
    Time Complexity: O(n)
    Space Complexity: O(n)
 */
public class TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // alternateive solution.
        // Create Another hashmap where key = counts, and value is list of indicies
        // loop through map backwards and add the list of indicies.
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }

        return result.stream().mapToInt(i->i).toArray();
    }
}
