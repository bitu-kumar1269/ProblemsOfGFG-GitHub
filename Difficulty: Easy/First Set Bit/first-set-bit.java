class Solution {
    public static int getFirstSetBit(int n) {
        // code here
        int count = 1;
        
        while(n > 0){
            if((n & 1) == 1){
                return count;
            }
            n =n >> 1;
            count++;
        }
        return 0;
    }
}