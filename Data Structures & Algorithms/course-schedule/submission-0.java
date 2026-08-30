class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }

        int[] visited = new int[numCourses];

        for(int i = 0; i<numCourses; i++){
            if(visited[i] == 0){
                if(hasCycle(adj, visited, i)){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean hasCycle(List<List<Integer>> adj, int[] visited, int curr){
        if(visited[curr] == 1){
            return true;
        }

        if(visited[curr] == 2){
            return false;
        }

        visited[curr] = 1;

        for(int neighbor : adj.get(curr)){
            if(hasCycle(adj, visited, neighbor)){
                return true;
            }
        }

        visited[curr] = 2;
        return false;
    }
}
