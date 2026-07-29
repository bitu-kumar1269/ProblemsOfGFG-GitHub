class Solution {
    public double medianOf2(int a[], int b[]) {
        // Your Code Here
        int n = a.length;
        int merge[] = new int[2*n];
        int i=0, j=0, k=0;
        while(i < n && j < n){
            if(a[i] <= b[j]){
                merge[k++]=a[i++];
            }
            else {
                merge[k++]=b[j++];
            }
        }
        // for remaning array a or b
        while(i<n) merge[k++]=a[i++];
        while(j<n) merge[k++]=b[j++];
        
        return (merge[n-1]+merge[n])/2.0;
    }
}