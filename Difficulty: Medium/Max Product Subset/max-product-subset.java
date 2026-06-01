class Solution {
    public int findMaxProduct(int[] arr) {
        int n = arr.length;
        
        if (n == 1) {
            return arr[0];
        }

        long maxNeg = Long.MIN_VALUE;
        int countNeg = 0;
        int countZero = 0;
        long prod = 1;
        long MOD = 1000000007;
        boolean hasPositive = false;

        for (int i = 0; i < n; i++) {
            int val = arr[i];

            if (val == 0) {
                countZero++;
                continue;
            }

            if (val < 0) {
                countNeg++;
                maxNeg = Math.max(maxNeg, val);
            } else {
                hasPositive = true;
            }

            prod = (prod * Math.abs(val)) % MOD;
        }

        if (countZero == n) {
            return 0;
        }

        if (!hasPositive && countNeg == 1 && countZero + countNeg == n) {
            return 0;
        }

        if (countNeg % 2 != 0) {
            prod = (prod / Math.abs(maxNeg)) % MOD;
        }

        return (int) prod;
    }
}