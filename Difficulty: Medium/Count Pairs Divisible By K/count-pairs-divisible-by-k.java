class Solution {
    public int countKdivPairs(int[] arr, int k) {
        long count = 0; 
        
        // Array to store frequencies of remainders (0 to k-1)
        int[] remFreq = new int[k];
        
        for (int i = 0; i < arr.length; i++) {
            int rem = arr[i] % k;
            
            // Find the complement remainder needed to make a sum divisible by k
            int target = (k - rem) % k;
            
            // Add the number of valid pairs we can form with the current element
            count += remFreq[target];
            
            // Record the current remainder for future elements to pair with
            remFreq[rem]++;
        }
        
        // Cast back to int to match the method signature
        return (int) count; 
    }
}