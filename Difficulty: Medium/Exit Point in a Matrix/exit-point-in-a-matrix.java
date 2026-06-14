import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> exitPoint(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        // Direction vectors arranged clockwise: Right, Down, Left, Up
        int[] delRow = {0, 1, 0, -1};
        int[] delCol = {1, 0, -1, 0};
        
        int i = 0, j = 0; // Start at top-left
        int dir = 0;      // Start moving Right
        
        // Track the last valid position inside the matrix
        int lastI = 0, lastJ = 0;
        
        while (i >= 0 && i < n && j >= 0 && j < m) {
            // Save current position before we potentially step out
            lastI = i;
            lastJ = j;
            
            // If we hit a 1, turn right clockwise and flip the cell to 0
            if (mat[i][j] == 1) {
                dir = (dir + 1) % 4;
                mat[i][j] = 0;
            }
            
            // Move to the next cell based on the current direction
            i += delRow[dir];
            j += delCol[dir];
        }
        
        // Return the last valid coordinates as a List
        List<Integer> ans = new ArrayList<>();
        ans.add(lastI);
        ans.add(lastJ);
        return ans;
    }
}