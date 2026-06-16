import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public ArrayList<Integer> constructList(int[][] queries) {
        ArrayList<Integer> result = new ArrayList<>();
        int cumulativeXor = 0;
        
        // Step 1: Process queries in reverse order
        for (int i = queries.length - 1; i >= 0; i--) {
            int type = queries[i][0];
            int x = queries[i][1];
            
            if (type == 1) {
                // Accumulate the XOR effect for all elements inserted before this point
                cumulativeXor ^= x;
            } else {
                // Type 0: Insert element pre-XORed with whatever future XORs will hit it
                result.add(x ^ cumulativeXor);
            }
        }
        
        // Step 2: Account for the initial 0 that was in the array at the very start
        result.add(0 ^ cumulativeXor);
        
        // Step 3: Sort the final list as requested by the problem statement
        Collections.sort(result);
        
        return result;
    }
}