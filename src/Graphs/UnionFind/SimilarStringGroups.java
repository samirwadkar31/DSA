package Graphs.UnionFind;

public class SimilarStringGroups {

    public static void main(String[] args) {
        String[] strs ={"tars","rats","arts","star"};

        System.out.println("Total identical string groups are: " + numSimilarGroups(strs));

    }
    public static int numSimilarGroups(String[] strs) {

        int n = strs.length;
        int groupsCount = n;
        UnionFind obj = new UnionFind(n);

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){

                if(identicalStrings(strs[i], strs[j]) && !obj.union(i, j)){
                    groupsCount--;
                }
            }
        }

        return groupsCount;
    }

    public static boolean identicalStrings(String s1, String s2){

        if(s1.equals(s2)) return true;

        int n = s1.length();
        int m = s2.length();

        if(n != m) return false;

        int i = -1;
        int j = -1;

        int swap = 0;

        for(int k = 0; k < n; k++){

            if(s1.charAt(k) == s2.charAt(k)) continue;

            if(i == -1) i = k;
            else if(j == -1) j = k;

            swap++;

            if(swap > 2) return false;
        }

        if(swap == 1) return false;
        if(swap == 2 && s1.charAt(i) == s2.charAt(j) && s2.charAt(i) == s1.charAt(j)) return true;

        return false;
    }
}


class UnionFind{

    int[] parent;
    int[] rank;

    public UnionFind(int n){
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
    }

    public boolean union(int a, int b){

        int pa = find(a);
        int pb = find(b);

        if(pa != pb){

            if(rank[pa] > rank[pb]){
                parent[pb] = parent[pa];
            }else if(rank[pb] > rank[pa]){
                parent[pa] = parent[pb];
            }else{
                parent[pb] = parent[pa];
                rank[pa]++;
            }

            return false;
        }

        return true;
    }

    public int find(int num){
        if(parent[num]==num){
            return num;
        }
        return parent[num]= find(parent[num]);
    }
}