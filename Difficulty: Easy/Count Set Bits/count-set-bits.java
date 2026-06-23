class Solution {
    static int setBits(int n) {
        // code here
        int bitscount = 0;
        String bits = Integer.toBinaryString(n);
        
        for(int i=0; i<bits.length(); i++){
            if(bits.charAt(i) == '1'){
                bitscount++;
            }
        }
        return bitscount;
        
    }
}