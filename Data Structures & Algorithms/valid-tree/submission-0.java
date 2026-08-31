class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1){
            return false;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        if(hasCycle(adj, visited, 0, -1)){
            return false;
        }

        return visited.size() == n;
    }

    private boolean hasCycle(List<List<Integer>> adj, Set<Integer> visited, int node, int parent){
        if(visited.contains(node)){
            return true;
        }

        visited.add(node);

        for(int neighbor : adj.get(node)){
            if(neighbor == parent){
                continue;
            }

            if(hasCycle(adj, visited, neighbor, node)){
                return true;
            }
        }

        return false;
    }
}
