class Solution {
    private static final int MOD = 1_000_000_007;

    public int countSubsets(int[] arr) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        int[] freq = new int[31];
        for (int num : arr) {
            freq[num]++;
        }

        // Map each number x in [1, 30] to its prime bitmask
        int[] masks = new int[31];
        for (int i = 2; i <= 30; i++) {
            int temp = i;
            int mask = 0;
            boolean isSquareFree = true;

            for (int p = 0; p < primes.length; p++) {
                int prime = primes[p];
                int count = 0;
                while (temp % prime == 0) {
                    count++;
                    temp /= prime;
                }
                if (count > 1) { // Divisible by prime^2 -> invalid
                    isSquareFree = false;
                    break;
                }
                if (count == 1) {
                    mask |= (1 << p);
                }
            }

            masks[i] = isSquareFree ? mask : -1;
        }

        // DP array: dp[mask] = count of subsets with prime factors bitmask
        long[] dp = new long[1024];
        dp[0] = 1;

        for (int i = 2; i <= 30; i++) {
            if (freq[i] == 0 || masks[i] == -1) continue;

            int m = masks[i];
            long count = freq[i];

            for (int state = 1023; state >= 0; state--) {
                if ((state & m) == 0 && dp[state] > 0) {
                    dp[state | m] = (dp[state | m] + dp[state] * count) % MOD;
                }
            }
        }

        // Sum up all non-empty subsets (mask > 0)
        long totalValidSubsets = 0;
        for (int mask = 1; mask < 1024; mask++) {
            totalValidSubsets = (totalValidSubsets + dp[mask]) % MOD;
        }

        // Account for 1s: each valid subset can combine with any subset of 1s (2^freq[1])
        long onesFactor = 1;
        for (int i = 0; i < freq[1]; i++) {
            onesFactor = (onesFactor * 2) % MOD;
        }

        return (int) ((totalValidSubsets * onesFactor) % MOD);
    }
}