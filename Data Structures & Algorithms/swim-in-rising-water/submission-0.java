class Solution {
    public int swimInWater(int[][] grid) {
        // left to right path that has lowest min
        // screams dp at any point dp[i][j] = lowest max needed to get to this spot.
        // edge case to be aware of is when we go down and the back up -> v -> ^ -> v v
        // at lowest each point is gonna be itself
        // djikstras is lowest value path. one way we can do this is once we see a new ma value like 5 treat all nodes out of that as at least 5
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> grid[b[0]][b[1]] - grid[a[0]][a[1]]);
        // if seen set value negative with highest edge thus far
        int n = grid.length;
        pq.offer(new int[]{0,0});
        grid[0][0] = -grid[0][0]-1;
        while (!pq.isEmpty()) {
            int[] square = pq.poll();
            int i = square[0];
            int j = square[1];
            if (i == n-1 && j == n-1) {
                break;
            }
            if (i != 0 && grid[i-1][j] >= 0) {
                grid[i-1][j] = Math.min(grid[i][j], -grid[i-1][j]-1);
                pq.offer(new int[]{i-1, j});
            }
            if (i != n-1 && grid[i+1][j] >= 0) {
                grid[i+1][j] = Math.min(grid[i][j], -grid[i+1][j]-1);
                pq.offer(new int[]{i+1, j});
            }
            if (j != 0 && grid[i][j-1] >= 0) {
                grid[i][j-1] = Math.min(grid[i][j], -grid[i][j-1]-1);
                pq.offer(new int[]{i, j-1});
            }
            if (j != n-1 && grid[i][j+1] >= 0) {
                grid[i][j+1] = Math.min(grid[i][j], -grid[i][j+1]-1);
                pq.offer(new int[]{i, j+1});
            }
            
        }

        return -grid[n-1][n-1]-1;
    }
}
