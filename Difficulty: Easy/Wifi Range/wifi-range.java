class Solution {
    static boolean wifiRange(String s, int x) {
        int n = s.length();
        
        // Keeps track of the rightmost covered room
        int maxReach = -1; 

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {

                // If gap exists between previous
                // coverage and current WiFi
                if (maxReach < i - x - 1) {
                    return false;
                }

                // Update maximum reach
                maxReach = Math.max(maxReach, i + x);
            }
        }

        // Check if last position is covered
        return maxReach >= n - 1;
    }
}