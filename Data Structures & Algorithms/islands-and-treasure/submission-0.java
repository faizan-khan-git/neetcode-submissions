class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if(grid == null || grid.length == 0){
            return;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        // enqueue all treasure chests (starting point)
        for(int r = 0; r<rows; r++){
            for(int c = 0; c<cols; c++){
                if(grid[r][c] == 0){
                    q.offer(new int[]{r, c});
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // perform BFS expanding outwards from all chests simultaneously
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            // check all 4 adj cell
            for(int[] dir: directions){
                int newRow = r + dir[0];
                int newCol = c + dir[1];

                if(newRow < 0 || newCol < 0 || newRow >= rows || newCol >= cols || grid[newRow][newCol] != Integer.MAX_VALUE){
                    continue;
                }

                grid[newRow][newCol] = grid[r][c] + 1;

                q.offer(new int[]{newRow, newCol});
            }
        }
    }
}
