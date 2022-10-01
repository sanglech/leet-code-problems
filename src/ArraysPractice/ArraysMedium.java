package ArraysPractice;

import java.util.*;

public class ArraysMedium {

    // Time Complexity: O(mlogn)
    // Space: O(n)
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

    // Time Complexity: O(n)
    // Space Complexity: O(n)
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

    // Time Complexity: O(n)
    // Space: O(n)

    public static int[] productExceptSelf(int[] nums) {
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

    // Time Complexity: O(n*m)
    //Space: O(n)
    public static boolean isValidSudoku(char[][] board) {
        HashSet<String> h1 = new HashSet<String>();
        for(int row=0; row < 9; row++){
            for(int col=0; col< 9; col++){
                if(board[row][col] != '.'){
                    //Check whether HashSet contains duplicate elements in row and column
                    if(h1.contains("row" + row + board[row][col]) || h1.contains("col" + col + board[row][col]) ){
                        return false;
                    }
                    h1.add("row" + row + board[row][col]);
                    h1.add("col" + col + board[row][col]);

                    //Check whether Box contains duplicate elements in it
                    if(h1.contains("box"+ (row/3) + (col/3) + board[row][col])){
                        return false;
                    }
                    h1.add("box"+ (row/3) + (col/3) + board[row][col]);
                }
            }
        }
        return true;
    }
    // Time Complexity: O(n)
    // Space: O(n)
    public String encode(List<String> strs) {
        // write your code here
        StringBuilder result = new StringBuilder();
        for (String s: strs){
            result.append(s.length()).append("#").append(s);
        }

        return result.toString();
    }

    public List<String> decode(String str) {
        // write your code here
        List<String> result = new ArrayList<>();
        int i =0;

        while(i<str.length()){
            int j = i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int length = Integer.parseInt(String.valueOf(str.charAt(j-1)));

            String temp = str.substring(j+1,j+length+1);

            result.add(temp);
            i=j+1+length;
        }

        return result;
    }

    // Time Complexity: O(n)
    // Space: O(n)
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();

        int longest = 0;
        for(int i: nums){
            numSet.add(i);
        }

        for (int num: nums){
            int curr =1;
            if(!numSet.contains(num-1)){
                int i=1;
                while(numSet.contains(num+i)){
                    curr++;
                    i++;
                }

            }
            longest = Math.max(longest,curr);
        }

        return longest;
    }

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> sMap = new HashMap<>();
        HashMap<Character,Character> tMap = new HashMap<>();

        if(s.length()!=t.length()){
            return false;
        }

        for (int i =0; i< s.length();i++){
            if(!sMap.containsKey(s.charAt(i))) sMap.put(s.charAt(i),t.charAt(i));
            if(!tMap.containsKey(t.charAt(i))) tMap.put(t.charAt(i),s.charAt(i));
        }
        for(int i=0;i<t.length();i++){
            if(tMap.get(t.charAt(i)) != s.charAt(i) || sMap.get(s.charAt(i)) != t.charAt(i))
            {return false;}
        }

        return true;
    }


}
