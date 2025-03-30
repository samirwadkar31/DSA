package DynamicProgramming.MatrixGrid;

public class MaximalSquare {
    public static void main(String[] args) {
        char[][] matrix = {{},{},{}};

        int ans = maximalSquare(matrix);

        System.out.println("Maximum area: " + maximalSquare(matrix));

    }

    public static int maximalSquare(char[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];

        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if((i == 0 || j == 0) && matrix[i][j] == '1'){

                    dp[i][j] = 1;

                }else{
                    if(matrix[i][j] == '1'){
                        dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                    }
                }

                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans*ans;
    }
}
