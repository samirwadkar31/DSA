package DynamicProgramming.MatrixGrid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        int result = minimumTotal(triangle);
        System.out.println("Minimum path sum: " + result);
    }

    public static int minimumTotal(List<List<Integer>> triangle) {


        int n = triangle.size();
        int[][] directions = {{1,0}, {1,1}};

        List<List<Integer>> dp = new ArrayList<>();

        for(int i = 0; i < n; i++){
            dp.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < triangle.get(i).size(); j++){
                dp.get(i).add(Integer.MAX_VALUE);
            }
        }

        int ans = dfs(triangle, 0, 0, n, directions, dp);

        return ans;
    }

    public static int dfs(List<List<Integer>> triangle, int i, int j, int n, int[][] directions, List<List<Integer>> dp){

        if(i == n -1) return triangle.get(i).get(j);

        if(dp.get(i).get(j) != Integer.MAX_VALUE) return dp.get(i).get(j);

        int sum = triangle.get(i).get(j);

        int minPathSum = Integer.MAX_VALUE;

        for(int[] dir: directions){

            int x = i + dir[0];
            int y = j + dir[1];

            minPathSum = Math.min(minPathSum, dfs(triangle, x, y, n, directions, dp));
        }

        sum += minPathSum;
        dp.get(i).set(j, sum);
        return sum;
    }
}
