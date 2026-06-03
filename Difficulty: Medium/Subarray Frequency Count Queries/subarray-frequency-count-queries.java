class Solution {
    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Map to store element -> list of its indices
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        
        // Process each query
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int x = query[2];
            
            if (!map.containsKey(x)) {
                result.add(0);
                continue;
            }
            
            ArrayList<Integer> indices = map.get(x);
            
            // Find the number of elements <= r and elements < l
            int upper = upperBound(indices, r);
            int lower = lowerBound(indices, l);
            
            result.add(upper - lower);
        }
        
        return result;
    }
    private int upperBound(ArrayList<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    private int lowerBound(ArrayList<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }    
}