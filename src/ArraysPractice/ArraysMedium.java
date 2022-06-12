package ArraysPractice;

import java.util.*;

public class ArraysMedium {

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        List<List<String>> result = new ArrayList<List<String>>();

        for(String s: strs){
            char [] temp = s.toCharArray();
            Arrays.sort(temp);

            if(map.containsKey(Arrays.toString(temp))) {
                map.get(Arrays.toString(temp)).add(s);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(s);
                map.put(Arrays.toString(temp),newList);
            }
        }

        for(String key: map.keySet()){
            result.add(map.get(key));
        }

        return result;
    }

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
                new PriorityQueue<>((e1, e2) -> e1.getValue() -e2.getValue());

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

    public int[] productExceptSelf(int[] nums) {
        int preFix =1;
        int postFix =1;

        int [] res = new int[nums.length];

        for(int i =0; i<nums.length;i++){
            res[i] = preFix;
            preFix = nums[i]*preFix;
        }

        for(int j= res.length-1;j>=0;j--){
            res[j]= postFix*res[j];
            postFix = postFix*nums[j];
        }

        return res;
    }
}
