package Graphs.BFS;

import java.util.*;

public class MinimumGeneticMutation {
    public static void main(String[] args) {
        String startGene = "AACCGGTT";
        String endGene = "AAACGGTA";
        String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};

        System.out.println("Minimum Mutation: " + minMutation(startGene, endGene, bank));
    }

    public static int minMutation(String startGene, String endGene, String[] bank) {

        Set<String> bankSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        String gene = "ACGT";

        for(String s: bank){
            bankSet.add(s);
        }

        if (!bankSet.contains(endGene)) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();

        queue.offer(startGene);
        visited.add(startGene);
        int level = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int k = 0; k < size; k++){
                String str = queue.poll();

                if(str.equals(endGene)){
                    return level;
                }

                for(int i = 0; i < str.length(); i++){
                    StringBuilder sb = new StringBuilder(str);
                    for(char ch: gene.toCharArray()){

                        sb.setCharAt(i, ch);
                        String temp = sb.toString();

                        if(!visited.contains(temp) && bankSet.contains(temp)){
                            queue.offer(temp);
                            visited.add(temp);
                        }
                    }
                }
            }

            level++;
        }

        return -1;
    }
}
