class Solution {
    public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Edge case: For n = 1, 0 is a valid single-digit increasing number
        if (n == 1) {
            for (int i = 0; i <= 9; i++) {
                result.add(i);
            }
            return result;
        }
        
        // If n > 9, no such number can be formed with strictly increasing digits
        if (n > 9) {
            return result;
        }
        
        // Start recursion: building numbers of length n
        // The first digit for an n-digit number (where n > 1) ranges from 1 to 9
        generateNumbers(n, 0, 0, result);
        
        return result;
    }
    
    private static void generateNumbers(int n, int currentNum, int lastDigit, ArrayList<Integer> result) {
        // Base case: If we have built a number with n digits, add it to the list
        if (n == 0) {
            result.add(currentNum);
            return;
        }
        
        // The next digit must be strictly greater than lastDigit
        for (int i = lastDigit + 1; i <= 9; i++) {
            // Append the digit 'i' to currentNum
            generateNumbers(n - 1, currentNum * 10 + i, i, result);
        }
    }
}