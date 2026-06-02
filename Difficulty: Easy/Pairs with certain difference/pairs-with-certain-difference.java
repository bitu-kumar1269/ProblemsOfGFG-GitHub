class Solution {
    public int sumDiffPairs(int[] arr, int k) {
        // Step 1: Sort the array to easily find close elements
        Arrays.sort(arr);
        
        int maxSum = 0;
        int i = arr.length - 1; // Start from the largest element
        
        // Step 2: Traverse from right to left greedily
        while (i > 0) {
            // Check if the current adjacent pair satisfies the difference condition
            if (arr[i] - arr[i - 1] < k) {
                maxSum += arr[i] + arr[i - 1];
                i -= 2; // Skip both elements as pairs must be disjoint
            } else {
                i--; // Move to the next largest element
            }
        }
        
        return maxSum;
    }
}