package Graphs.BFS;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        System.out.println("Number of words in the shortest transformation sequence: " + ladderLength(beginWord, endWord, wordList));

    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordListSet = new HashSet<>();
        Set<String> visited = new HashSet<>();

        for(String s: wordList){
            wordListSet.add(s);
        }

        if (!wordListSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);
        visited.add(beginWord);
        int level = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int k = 0; k < size; k++){
                String str = queue.poll();

                if(str.equals(endWord)){
                    level++;
                    return level;
                }

                for(int i = 0; i < str.length(); i++){
                    StringBuilder sb = new StringBuilder(str);
                    for(int j = 0; j < 26; j++){

                        sb.setCharAt(i, (char)(j + 'a'));
                        String temp = sb.toString();

                        if(!visited.contains(temp) && wordListSet.contains(temp)){
                            queue.offer(temp);
                            visited.add(temp);
                        }
                    }
                }
            }

            level++;
        }

        return 0;
    }
}
