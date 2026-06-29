class Solution {
    public int maxDotProduct(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        
        // dp[i][j] stores the max dot product of a[0...i-1] and b[0...j-1]
        int[][] dp = new int[n + 1][m + 1];
        
        // Traverse through both arrays
        for (int i = 1; i <= n; i++) {
            // j cannot exceed i because b needs at least j elements from a
            for (int j = 1; j <= Math.min(i, m); j++) {
                
                // Option 1: Multiply a[i-1] and b[j-1]
                int take = dp[i-1][j-1] + a[i-1] * b[j-1];
                
                // Option 2: Skip a[i-1] (multiply it with an inserted 0)
                // This is only valid if we have enough elements left (i-1 >= j)
                int skip = (i - 1 >= j) ? dp[i-1][j] : 0;
                
                dp[i][j] = Math.max(take, skip);
            }
        }
        
        return dp[n][m];
    }
}