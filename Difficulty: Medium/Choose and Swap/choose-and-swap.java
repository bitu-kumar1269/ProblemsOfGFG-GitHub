import java.util.TreeSet;

class Solution {
    public String chooseSwap(String s) {
        // Step 1: Use a TreeSet to keep track of unique characters in sorted order
        TreeSet<Character> set = new TreeSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        // Step 2: Iterate through the string to find the first improvable character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // Remove the current character from the set so we don't compare it with itself
            set.remove(ch);

            // If the set is empty, no smaller characters are available ahead
            if (set.isEmpty()) {
                break;
            }

            // Get the smallest remaining character in the alphabet
            char smallestAvailable = set.first();

            // If the smallest available character is smaller than our current character, 
            // we found our optimal swap pair!
            if (smallestAvailable < ch) {
                char charToReplace = ch;
                char replacement = smallestAvailable;

                // Rebuild the string by swapping all occurrences of 'charToReplace' and 'replacement'
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == charToReplace) {
                        sb.append(replacement);
                    } else if (s.charAt(j) == replacement) {
                        sb.append(charToReplace);
                    } else {
                        sb.append(s.charAt(j));
                    }
                }
                return sb.toString();
            }
        }

        // If no optimal swap was found, return the original string
        return s;
    }
}