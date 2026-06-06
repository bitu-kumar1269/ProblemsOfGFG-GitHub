class Solution {
    public int numOfWays(int n, int m) {
        long cells = 1L * n * m;

        long totalWays = cells * (cells - 1);

        long attackingWays = 0;

        if (n >= 2 && m >= 3) {
            attackingWays += 4L * (n - 1) * (m - 2);
        }

        if (n >= 3 && m >= 2) {
            attackingWays += 4L * (n - 2) * (m - 1);
        }

        return (int)(totalWays - attackingWays);
    }
}