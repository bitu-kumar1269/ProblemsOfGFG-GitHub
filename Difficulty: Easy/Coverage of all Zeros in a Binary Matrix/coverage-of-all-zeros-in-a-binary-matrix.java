class Solution {
    public int findCoverage(int[][] mat) {
        int totalCoverage = 0;
        int rows = mat.length;
        int cols = mat[0].length;
        
        // Traverse the entire matrix
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                
                // We only calculate coverage for '0' cells
                if (mat[r][c] == 0) {
                    
                    // 1. Check Up
                    for (int i = r - 1; i >= 0; i--) {
                        if (mat[i][c] == 1) {
                            totalCoverage++;
                            break; // Found a 1, move to the next direction
                        }
                    }
                    
                    // 2. Check Down
                    for (int i = r + 1; i < rows; i++) {
                        if (mat[i][c] == 1) {
                            totalCoverage++;
                            break; 
                        }
                    }
                    
                    // 3. Check Left
                    for (int j = c - 1; j >= 0; j--) {
                        if (mat[r][j] == 1) {
                            totalCoverage++;
                            break; 
                        }
                    }
                    
                    // 4. Check Right
                    for (int j = c + 1; j < cols; j++) {
                        if (mat[r][j] == 1) {
                            totalCoverage++;
                            break; 
                        }
                    }
                }
                
            }
        }
        
        return totalCoverage;
    }
}