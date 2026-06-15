class Solution {
    public int minimumCost(int[] cost, int w) {
        int n = cost.length;
        int[] dp = new int[w + 1];
        
        // Initialize the DP array with a large value representing infinity
        // Using Integer.MAX_VALUE / 2 to prevent integer overflow during addition
        int INF = Integer.MAX_VALUE / 2;
        for (int i = 1; i <= w; i++) {
            dp[i] = INF;
        }
        
        // Base case: 0 weight costs 0
        dp[0] = 0;
        
        // Iterate through all available packet types
        for (int i = 0; i < n; i++) {
            int packetWeight = i + 1;
            int packetCost = cost[i];
            
            // Skip the packet if it's unavailable
            if (packetCost == -1) {
                continue;
            }
            
            // Update the DP array for all weights that can include this packet
            for (int j = packetWeight; j <= w; j++) {
                if (dp[j - packetWeight] != INF) {
                    dp[j] = Math.min(dp[j], dp[j - packetWeight] + packetCost);
                }
            }
        }
        
        // If dp[w] is still INF, it means it's impossible to make exactly w kg
        return dp[w] == INF ? -1 : dp[w];
    }
}