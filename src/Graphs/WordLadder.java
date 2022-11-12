package Graphs;

import java.util.*;

/*
    127. Word Ladder
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;

        Map<String, List<String>> adjlist = new HashMap<>();
        wordList.add(beginWord);
        for (String word : wordList) {
            StringBuilder pattern;
            for (int i = 0; i < word.length(); i++) {
                pattern = new StringBuilder(word);
                pattern.setCharAt(i, '*');
                List<String> wordlist = adjlist.getOrDefault(
                        pattern.toString(),
                        new ArrayList<String>()
                );
                wordlist.add(word);
                adjlist.put(pattern.toString(), wordlist);
            }
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int step = 1;
        StringBuilder string = null;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String str = queue.poll();

                for (int i = 0; i < str.length(); i++) {
                    string = new StringBuilder(str);
                    string.setCharAt(i, '*');
                    for (String pat : adjlist.get(string.toString())) {
                        if (pat.equals(endWord)) {
                            return step;
                        }
                        if (visited.contains(pat)) {
                            continue;
                        }
                        queue.offer(pat);
                        visited.add(pat);
                    }
                }
            }
        }

        return 0;
    }
}
