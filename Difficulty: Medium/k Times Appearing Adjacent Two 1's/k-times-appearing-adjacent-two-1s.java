class Solution {
    public int countStrings(int n, int k) {
        if (k >= n) return 0;
        
        int MOD = 1000000007;
        int[][] dp = new int[k + 1][2];
        
        dp[0][0] = 1;
        dp[0][1] = 1;
        
        for (int i = 2; i <= n; i++) {
            int[][] nextDp = new int[k + 1][2];
            
            for (int j = 0; j <= k; j++) {
                nextDp[j][0] = (dp[j][0] + dp[j][1]) % MOD;
                
                nextDp[j][1] = dp[j][0];
                
                if (j > 0) {
                    nextDp[j][1] = (nextDp[j][1] + dp[j - 1][1]) % MOD;
                }
            }
            dp = nextDp;
        }
        
        return (dp[k][0] + dp[k][1]) % MOD;
    }
}