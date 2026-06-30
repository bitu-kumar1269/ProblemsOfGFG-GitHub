import java.util.*;

class Solution {
    public int minInsAndDel(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        
        // Step 1: Map elements of b[] to their indices for O(1) lookups
        Map<Integer, Integer> bMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            bMap.put(b[i], i);
        }
        
        // Step 2: Filter array a[] to keep only elements present in b[], 
        // replacing them with their index positions in b[]
        List<Integer> filteredA = new ArrayList<>();
        for (int num : a) {
            if (bMap.containsKey(num)) {
                filteredA.add(bMap.get(num));
            }
        }
        
        // Step 3: Find the Longest Increasing Subsequence (LIS) of filteredA
        int lcsLength = findLIS(filteredA);
        
        // Step 4: Calculate total insertions and deletions
        return (n - lcsLength) + (m - lcsLength);
    }
    
    // Optimal LIS implementation using Binary Search: O(N log N)
    private int findLIS(List<Integer> nums) {
        if (nums.isEmpty()) return 0;
        
        List<Integer> tail = new ArrayList<>();
        for (int num : nums) {
            int idx = Collections.binarySearch(tail, num);
            if (idx < 0) {
                idx = -(idx + 1);
            }
            
            if (idx == tail.size()) {
                tail.add(num);
            } else {
                tail.set(idx, num);
            }
        }
        return tail.size();
    }
}