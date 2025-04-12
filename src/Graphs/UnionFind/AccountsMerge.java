package Graphs.UnionFind;

import java.util.*;

public class AccountsMerge {

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();

        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));

        List<List<String>> mergedAccounts = accountsMerge(accounts);

        for (List<String> account : mergedAccounts) {
            System.out.println(account);
        }
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();
        unionFind uf = new unionFind(n);

        Map<String, Integer> owners = new HashMap<>();

        for(int i = 0; i < n; i++){
            for(int j = 1; j < accounts.get(i).size(); j++){

                if(!owners.containsKey(accounts.get(i).get(j))){
                    owners.put(accounts.get(i).get(j), i);
                }else{
                    uf.union(owners.get(accounts.get(i).get(j)), i);
                }
            }
        }

        List<List<String>> temp = new ArrayList<>();

        for(int i = 0; i < n; i++){
            temp.add(new ArrayList<>());
        }

        for(Map.Entry<String, Integer> entry: owners.entrySet()){

            String email = entry.getKey();
            int value = entry.getValue();

            int parentOfEmail = uf.find(value);

            temp.get(parentOfEmail).add(email);
        }

        for(List<String> list: temp){
            Collections.sort(list);
        }

        List<List<String>> res = new ArrayList<>();

        for(int i = 0; i < n; i++){

            if(temp.get(i).size() == 0) continue;

            List<String> ans = new ArrayList<>();
            ans.add(accounts.get(i).get(0));

            ans.addAll(temp.get(i));

            res.add(new ArrayList<>(ans));
        }

        return res;
    }
}

class unionFind{

int[] parent;
int n;

    public unionFind(int n){
        this.n = n;
        this.parent = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
    }


    public void union(int a, int b){

        int p1 = find(a);
        int p2 = find(b);

        if(p1 != p2){
            parent[p2] = p1;
        }

        return;
    }

    public int find(int num){
        if(parent[num] == num){
            return num;
        }

        return parent[num] = find(parent[num]);
    }
}
