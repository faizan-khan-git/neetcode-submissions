class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int freshCount = 0;

        // iterating grid to find initial rotten and count fresh fruits
        for(int r = 0; r<rows; r++){
            for(int c = 0; c<cols; c++){
                if(grid[r][c] == 2){
                    q.offer(new int[]{r, c});
                }else if(grid[r][c] == 1){
                    freshCount++;
                }
            }
        }

        if(freshCount == 0){
            return 0;
        }

        int minutes = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // process rot min by min using BFS
        while(!q.isEmpty() && freshCount > 0){
            int size = q.size();

            // process all fruit for curr min
            for(int i = 0; i<size; i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                // check 4 adj direction
                for(int[] dir : directions){
                    int newRow = r + dir[0];
                    int newCol = c + dir[1];

                    if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1){
                        grid[newRow][newCol] = 2;
                        freshCount--;
                        q.offer(new int[]{newRow, newCol});
                    }
                }
            }
            minutes++;
        }

        return freshCount == 0 ? minutes : -1;
    }
}
