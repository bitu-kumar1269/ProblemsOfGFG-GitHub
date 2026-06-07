class Solution {
    public String profession(int level, int pos) {
        // code here
        if (pos == 1) {
            return "Engineer";
        }
        
        // Find the profession of the parent
        String parentProfession = profession(level - 1, (pos + 1) / 2);
        
        // If pos is odd, it's the 1st child -> Same as parent
        if (pos % 2 != 0) {
            return parentProfession;
        } 
        // If pos is even, it's the 2nd child -> Opposite of parent
        else {
            return parentProfession.equals("Engineer") ? "Doctor" : "Engineer";
        }
    }
}