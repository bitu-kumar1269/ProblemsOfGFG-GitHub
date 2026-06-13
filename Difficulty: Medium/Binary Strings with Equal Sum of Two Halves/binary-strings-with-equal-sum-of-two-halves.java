class Solution {
    private static final int MOD = 1000000007;

    public int computeValue(int n) {
        // We need to calculate (2n)! / (n! * n!) % MOD
        long numerator = 1;
        long denominator = 1;

        // Calculate (2n)! and n! simultaneously to save time
        for (int i = 1; i <= 2 * n; i++) {
            numerator = (numerator * i) % MOD;
            
            if (i <= n) {
                denominator = (denominator * i) % MOD;
            }
        }

        // denominator^2 % MOD because we need (n! * n!)
        denominator = (denominator * denominator) % MOD;

        // Calculate modular inverse of denominator using Fermat's Little Theorem
        long inverseDenominator = power(denominator, MOD - 2);

        // Final result: (numerator * inverseDenominator) % MOD
        return (int) ((numerator * inverseDenominator) % MOD);
    }

    // Helper function to calculate (base^exp) % MOD in O(log exp) time
    private long power(long base, int exp) {
        long res = 1;
        base = base % MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }
}