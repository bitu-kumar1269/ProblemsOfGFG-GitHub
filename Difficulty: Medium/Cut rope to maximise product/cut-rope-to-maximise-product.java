class Solution {
    public int maxProduct(int n) {
        // Base cases where mandatory cut reduces or keeps value the same
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        
        int res = 1;
        
        // Keep multiplying by 3 until n is 4 or less
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        
        // Multiply by the remaining piece (which will be 2, 3, or 4)
        return res * n;
    }
}