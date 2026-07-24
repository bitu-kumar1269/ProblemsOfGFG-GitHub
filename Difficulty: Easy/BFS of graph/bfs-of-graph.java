class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0);
        visited[0] = true;
        
        while(!q.isEmpty()){
            int node = q.poll();
            bfs.add(node);
            
            for(int item: adj.get(node)){
                if(visited[item] == false){ // !visited[item]
                    visited[item]= true;
                    q.add(item);
                }
            }
        }
        return bfs;
    }
}