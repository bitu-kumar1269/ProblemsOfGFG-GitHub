class Solution {
    public boolean canSeatAllPeople(int k, int[] seats) {
        int n = seats.length;
        
        // Step 1: Check for any pre-existing invalid adjacent seats
        for (int i = 0; i < n - 1; i++) {
            if (seats[i] == 1 && seats[i + 1] == 1) {
                return false;
            }
        }
        
        // Step 2: Try to place the k people
        for (int i = 0; i < n; i++) {
            if (seats[i] == 0) {
                // Check if left and right conditions are met
                boolean leftEmpty = (i == 0 || seats[i - 1] == 0);
                boolean rightEmpty = (i == n - 1 || seats[i + 1] == 0);
                
                if (leftEmpty && rightEmpty) {
                    seats[i] = 1; // Sit the person here
                    k--;          // One less person to seat
                    
                    if (k <= 0) {
                        return true;
                    }
                }
            }
        }
        
        return k <= 0;
    }
}