package Graphs.TopoLogicalSort;

import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {
        String[] words = {"wrt","wrf","er","ett","rftt"};

        System.out.println("Alien dictionary order: " + alienOrder(words));
    }

    public static String alienOrder(String[] words) {

        List<List<Integer>> adj= new ArrayList<>();

        for(int i=0; i<26; i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree= new int[26];
        Arrays.fill(indegree, -1);

        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (indegree[c - 'a'] == -1) {
                    indegree[c - 'a'] = 0;
                }
            }
        }

        for(int i=0; i<words.length-1; i++){

            String s1= words[i];
            String s2= words[i+1];

            int len= Math.min(s1.length(), s2.length());

            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return "";
            }

            for(int j=0; j<len; j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    indegree[s2.charAt(j)-'a']++;
                    break;
                }
            }
        }

        Queue<Integer> queue= new LinkedList<>();

        for(int i=0; i<26; i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(queue.size()!=0){
            int u= queue.poll();

            sb.append((char)(u+'a'));

            for(int v: adj.get(u)){
                indegree[v]--;
                if(indegree[v]==0){
                    queue.add(v);
                }
            }

        }

        for (int i = 0; i < 26; i++) {
            if (indegree[i] > 0) {
                return "";
            }
        }

        return sb.toString();

    }
}
