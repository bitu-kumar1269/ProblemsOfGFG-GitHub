class Solution {
    public int getLastDigit(String a, String b) {
        // Edge case: Any number to the power of 0 is 1
        if (b.equals("0")) {
            return 1;
        }
        
        // Step 1: Get the last digit of base 'a'
        int base = a.charAt(a.length() - 1) - '0';
        
        // Step 2: Find b % 4 using its last two digits
        int exp;
        if (b.length() == 1) {
            exp = Integer.parseInt(b);
        } else {
            // Take the last two characters of string b
            exp = Integer.parseInt(b.substring(b.length() - 2));
        }
        
        exp = exp % 4;
        // If remainder is 0, it means it falls on the 4th position of the cycle
        if (exp == 0) {
            exp = 4;
        }
        
        // Step 3: Calculate the last digit safely
        int result = (int) Math.pow(base, exp);
        
        return result % 10;
    }
}