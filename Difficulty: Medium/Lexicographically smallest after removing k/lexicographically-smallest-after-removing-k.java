class Solution {
    public String lexicographicallySmallest(String s, int k) {
        int n = s.length();
        
        // Step 1: Correct the value of k
        // Check if n is a power of 2
        if ((n & (n - 1)) == 0) {
            k = k / 2;
        } else {
            k = k * 2;
        }
        
        // Edge cases: if k is greater than length, or if removing k leaves an empty string
        if (k >= n || k < 0) {
            return "-1";
        }
        
        // Step 2: Use a StringBuilder as a stack for the greedy approach
        StringBuilder stack = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            
            // Pop from stack if current char is smaller than the top of the stack
            while (stack.length() > 0 && k > 0 && stack.charAt(stack.length() - 1) > ch) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(ch);
        }
        
        // If we still need to remove characters, remove them from the end
        while (k > 0 && stack.length() > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }
        
        return stack.toString();
    }
}
