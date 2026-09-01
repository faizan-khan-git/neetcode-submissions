class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];

        for(int i = 1; i<=n; i++){
            parent[i] = i;
        }

        for(int[] edge : edges){
            if(!union(parent, edge[0], edge[1])){
                return edge;
            }
        }

        return new int[0];
    }

    private int find(int[] parent, int i){
        if(parent[i] == i){
            return i;
        }
        return parent[i] = find(parent, parent[i]);
    }

    private boolean union(int[] parent, int x, int y){
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if(rootX == rootY){
            return false;
        }

        parent[rootY] = rootX;
        return true;
    }
}
