class Solution {
    private Integer[][] dp;

    public int validGroups(String s) {
        int n = s.length();
        
        // Max possible sum of digits for a string of length 100 is 100 * 9 = 900
        dp = new Integer[n][901];
        
        return solve(0, 0, s);
    }

    private int solve(int index, int previousSum, String s) {
        // Base Case: If we have successfully grouped the entire string
        if (index == s.length()) {
            return 1;
        }

        // Return cached result if already calculated
        if (dp[index][previousSum] != null) {
            return dp[index][previousSum];
        }

        int currentSum = 0;
        int totalWays = 0;

        // Try creating all possible valid contiguous substrings starting from 'index'
        for (int i = index; i < s.length(); i++) {
            currentSum += s.charAt(i) - '0';

            // If the current subgroup sum satisfies the non-decreasing condition
            if (currentSum >= previousSum) {
                totalWays += solve(i + 1, currentSum, s);
            }
        }

        // Store the result in the DP table and return
        return dp[index][previousSum] = totalWays;
    }
}