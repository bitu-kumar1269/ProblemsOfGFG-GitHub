class Solution {
    int maxSubstring(String s) {
        int max_so_far = -1;
        int current_max = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Assign +1 for '0' and -1 for '1'
            int val = (s.charAt(i) == '0') ? 1 : -1;
            
            current_max += val;
            
            // Update the overall maximum found so far
            if (current_max > max_so_far) {
                max_so_far = current_max;
            }
            
            // If current sum becomes negative, reset it to 0
            if (current_max < 0) {
                current_max = 0;
            }
        }
        
        return max_so_far;
    }
}