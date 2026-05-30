class Solution {
    public void replaceElements(int[] arr) {
        int n = arr.length;
        if (n < 2) return;

        int prev = arr[0];

        arr[0] = arr[0] ^ arr[1];

        for (int i = 1; i < n - 1; i++) {
            int currentOriginal = arr[i]; 
            arr[i] = prev ^ arr[i + 1];   
            prev = currentOriginal;      
        }

        arr[n - 1] = prev ^ arr[n - 1];
    }
}