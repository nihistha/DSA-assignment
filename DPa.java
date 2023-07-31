class DPa{
    public static int minimumCost(int[][] price) {
        int n = price.length; // Number of people
        
        // Initialize dp array
        int[][] dp = new int[n][3];
        
        // Set initial values for the first person
        dp[0][0] = price[0][0];
        dp[0][1] = price[0][1];
        dp[0][2] = price[0][2];
        
        // Calculate minimum cost for subsequent people
        for (int i = 1; i < n; i++) {
            dp[i][0] = price[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = price[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = price[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        
        // Minimum cost required to purchase clothing sets
        int minCost = Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
        
        return minCost;
    }
    
    public static void main(String[] args) {
        int[][] price = {{1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9},
                    {23,1,4},
                {4,32,9}};
        int minCost = minimumCost(price);
        System.out.println("Minimum cost: " + minCost);
    }
}

