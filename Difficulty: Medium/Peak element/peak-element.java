class Solution {
    public int peakElement(int[] arr) {
        int n = arr.length;
        
        // Edge case: single element
        if (n == 1) return 0;
        
        int low = 0;
        int high = n - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Check if mid is a peak by comparing with neighbors (with boundary protection)
            boolean leftOk = (mid == 0) || (arr[mid] >= arr[mid - 1]);
            boolean rightOk = (mid == n - 1) || (arr[mid] >= arr[mid + 1]);
            
            if (leftOk && rightOk) {
                return mid;
            }
            
            // If the right neighbor is larger, a peak must exist on the right side
            if (mid < n - 1 && arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else { // Otherwise, a peak exists on the left side
                high = mid - 1;
            }
        }
        
        return -1;
    }
}